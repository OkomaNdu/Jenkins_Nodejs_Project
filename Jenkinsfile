#!/usr/bin/env groovy

@library('Jenkins_NodeJS_Shared_Library')
def gv

pipeline {
    agent any
    tools {
      nodejs 'node'
    }
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    stages {
        stage("init") {
           steps {
              script{
                 gv = load "script.groovy"
              }
           }
        }
        stage("build jar") {
            steps {
               script {
                  buildJar()
               }
            }
        }
        stage("test") {
            when {
                 expression {
                    params.executeTests
                 }
            }
            steps {
               script {
                  testApp()
                }
            }
        }
        stage("build image") {
            steps {
                script{
                  buildImage()
                }
            }
        }
        stage("deploy") {
            steps {
               script {
                   gv.deployApp(params.VERSION)
               }
            }
        }
    }
}