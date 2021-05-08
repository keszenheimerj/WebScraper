# WebScraper

Usr inputs a Facebook URL.
The Program uses a scanner, and a bufferReader to extract the text portion of the html.
Then, it proceeds to use ngrams to fetch important information from the file.

Go from this type of page
<img width="1105" alt="image" src="https://user-images.githubusercontent.com/78702929/117327586-c0d1cb00-ae60-11eb-856e-8fcfbd468a1f.png">
Simply grab the URL and input it into the run command line when prompted
<img width="1351" alt="image" src="https://user-images.githubusercontent.com/78702929/117327923-1efeae00-ae61-11eb-9c60-5052bcbb57d8.png">
Now you have fetched only the most important details (Currently just name and where they are from)

Explanation of Software 
<img width="1121" alt="image" src="https://user-images.githubusercontent.com/78702929/117552805-ac85fd80-b01b-11eb-9639-0c71954b51bc.png">
When opening the Html we fetch all of the text and split the text by spaces after changing non alphanumeric characters for spaces.
<img width="941" alt="image" src="https://user-images.githubusercontent.com/78702929/117552930-61b8b580-b01c-11eb-9678-5fb13f48c639.png">
Above we search to see if known tags are present that will accompany the information we are looking to snatch and then pass it on.
