export projectLocation=/opt/workspace/Workbox_auto
cd $projectLocation
export CLASSPATH=.:$projectLocation/lib/*:$projectLocation/bin
java org.testng.TestNG $projectLocation/testng.xml
#java -cp "/opt/GridImplementationRandD/lib/*:bin/*" org.testng.TestNG testng.xml



