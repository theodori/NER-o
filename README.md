# Name Entity Recognition Application.

This a NER application, integrating multiple NER apps/libs/models. based on different domains of interest.
  
The initial domains of interest are:
* General: Persons, Organizations, locations, time etc.
* Biomedical Entities
* TBD

## Notes
* Input: the app. takes as input an rdf graph as file and applies the ner process on specific attributes provided in the configuration
* Output: the app. outputs an rdf graph with the identified name entities using the NIF annotation ontology (http://persistence.uni-leipzig.org/nlp2rdf/) 
* All the ner.modules are abstracting 3rd-party ner libs/apps and we make the assumption that the will receive raw text in std.in and the will output
 the annotation text in std.out in BIO encoding (http://nltk.org/book/ch07.html)

# References
* Used this Java Lib to generate NIF rdf https://github.com/NLP2RDF/NIF-lib

