# SearchEngine
Java project for my course Advanced Computing Concepts

### Running the project
- Clone the github project
```
git clone https://github.com/malvat/SearchEngine.git
```
- Import the project into eclipse
- Run the project

### Instructions
- Enter the URL of the website you want to search the text from
- Enter the search text 
> Don't make spell errors, it's just a basic search program
- Wait for results to show

*P.S - Results can take time to show up*

### Thought Process
- Most basic thing about search engine is to search text. For this purpose, we have use KMP algorithm because, it is fast and easy to implement https://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm
- To search text, it is important that we get data from URL first into string or text. For this intent, we have just used URL and InputStream of Java
- Normalization: For search to be more appropriate with accordance of it's web page size, it is important that we normalize the result first. This was done fairly easily, with simple logic. 
- Sorting: Simple sorting could not have worked for us and fortunately, Java has some great library that we had used for implementing our own sort. (Comparator class)

