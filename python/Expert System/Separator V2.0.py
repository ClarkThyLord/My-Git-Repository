import re


def sentence_split(text):
    array = re.split(r"[.!?] ", text)

    if "" in array:
        array.remove("")

    print(array)

    return array


def word_split(sentences):
    print(sentences[1])
    for s in sentences:
        array = sentences[s].split()

    #array = sentences.split()

    if "" in array:
        array.remove("")

    print(array)

    return array


def start():
    raw = input()
    sentences = sentence_split(raw)
    words = word_split(list(sentences))
    print(words)

start()