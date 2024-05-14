// vars/DockerLabelArgs.groovy

def genrateDockerlabel(String version, boolean FIPS) {
    def BRANCH_NAME = 'master'
    def GIT_COMMIT = '012345'
    def branch = BRANCH_NAME ?: 'master'
    def gitHash = GIT_COMMIT ?: 'unknown'
    
    def labels = [
        'branch': branch,
        'version': version,
        'gitHash': gitHash,
        'FIPS': FIPS
    ]
    
    def labelArgs = labels.collect { key, value -> "--label $key=$value" }.join(' ')
    return labelArgs
}

// Test the function with some inputs
def version = '1.1.1-10'
def FIPS = false
def expectedLabelArgs = '--label branch=master --label version=1.1.1-10 --label gitHash=012345 --label FIPS=false'
def generatedLabelArgs = genrateDockerlabel(version, FIPS)

// Assert the expected output
assert generatedLabelArgs == expectedLabelArgs

// Print the label arguments for debugging
println("Generated label arguments: ${generatedLabelArgs}")
