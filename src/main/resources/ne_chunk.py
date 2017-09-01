from nltk import word_tokenize, pos_tag, ne_chunk
import sys
data = sys.stdin.readlines()
print ne_chunk(pos_tag(word_tokenize(str(data))))
