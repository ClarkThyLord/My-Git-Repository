

txt_arrays = []

def new_array():
    print("Give me some text...")
    txt = input()
    print(txt)

    txt_list = txt.split()
    print(txt_list)

    add_array(txt_list)


def add_array(txt_list):
    global txt_arrays

    txt_arrays.append(txt_list)
    print(txt_arrays)

    print("Print which array?")
    num = int(input())
    sentence = ""
    for w in txt_arrays[num]:
        sentence += " " + w
    print(sentence)
    print(txt_arrays[num])

    append_array()


def append_array():
    print("Which array would you like to add to?")
    num = int(input())
    print("What would you like to add?")
    word = str(input())

    txt_arrays[num].append(word)

    new_array()


new_array()