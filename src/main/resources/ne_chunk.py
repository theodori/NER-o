from nltk import word_tokenize, pos_tag, ne_chunk
import sys
data = sys.stdin.readlines()
chunked=ne_chunk(pos_tag(word_tokenize(str(data))))

def isNamedEntity(label):
    list=['NE','ORGANIZATION','PERSON', 'GPE']
    if label in list:
        return True
    else:
        return False

def extract_entity_names(t):
    entity_names = []
    if hasattr(t, 'label') and t.label:
        if isNamedEntity(t.label()) == True:
            entity_names.append((' '.join([child[0] for child in t]),t.label()))
        else:
            for child in t:
                entity_names.extend(extract_entity_names(child))

    return entity_names

entity_names = []
for tree in chunked:
    entity_names.extend(extract_entity_names(tree))
print set(entity_names)