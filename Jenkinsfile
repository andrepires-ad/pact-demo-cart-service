#!/usr/bin/env groovy

@Library('jenkins-shared-library') _

repositoryOwner = "andrepires-ad"
repositoryName = "pact-demo-cart-service"

pipeline {

    agent any

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out from repository...'
                checkout scm: [
                        $class: 'GitSCM',
                        branches: scm.branches,
                        userRemoteConfigs: scm.userRemoteConfigs,
                        extensions: [
                                [$class: 'CloneOption', noTags: false],
                                [$class: 'LocalBranch', localBranch: "**"]
                        ]
                ]
                script {
                    echo sh(returnStdout: true, script: 'env')
                    withPullRequestBranch {
                        sh "echo \"PR_NUMBER=$env.BRANCH_NAME\" >> gradle.properties"
                    }
                }
            }
        }

        stage('Build') {
            steps {
                echo 'Building project without tests.'
                sh "./gradlew clean build -x test"
            }
        }

        stage('Unit Test') {
            steps {
                echo 'Performing unit tests.'
            }
        }

        stage('Component Tests') {
            steps {
                echo 'Performing component tests.'
            }
        }

        stage('Static Analysis') {
            steps {
                echo 'Performing static analysis.'
            }
        }

        stage('Code Coverage') {
            steps {
                echo "Running code coverage."
            }
        }

        stage('Artifacts') {
            steps {
                echo "Publish artifacts."
            }
        }
    }
}
