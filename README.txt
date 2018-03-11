Project Configureation : 

IDE : eclipse mars  or above
Language : Java 1.8
Frameword: 
	1. Project Configureation : Maven 
	2. Test Frameword : Junit , 
	3. JSON Data Parsing Frameword : JsonPath - https://github.com/json-path/JsonPath

Project Setup Instruction steps : 

	1. Download Sourcecode from GitHub Reposotery 
	2. Make sure eclipse has maven installed (http://www.eclipse.org/m2e/)
	3. File --> Import Maven Project --> Select downloaded Folder (or you can directly clone from github)
	4. Once the project is being setup success fully please do following 
	5. Maven --> Update Project 
	6. Maven --> Clean 
	7. Start pinDrop testApi on localhost 
	8. Execute Test case : Maven Install  or Run as JUnit Test
	
Note : 

	1. TestData.json is a reference file for validing acutal output vs expected output. Instead of passing static data I copied all the data in TestDat.json file. It's comparing the value against API Resposne. 
	2. I have included  sample test coverage in "pinDrop RestAPI TestCoverage.xlsx".  

	
