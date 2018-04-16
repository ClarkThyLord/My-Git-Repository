file_location = None
original_txt = None

def start():
    print("Starting up...")
    start_ask()


def start_ask():
    print("Would you like to load or write a file? ~ load - write ~")
    ans = input()
    if ans == "load":
        load_ask()
    elif ans == "write":
        writing()
    else:
        print("Sorry din't catch that can you repeat it?")
        start_ask()


def load_ask():
    global file_location

    print("What would you like to load?")
    file_location = input()
    load_ask1()



def load_ask1():
    global file_location

    print("Is " + file_location + " what you would like to load? ~ yes - no ~")
    ans = input()
    if ans == "yes":
        loading()
    elif ans == "no":
        load_ask2()
    else:
        print("Sorry din't catch that can you repeat it?")
        load_ask1()


def load_ask2():
    print("Change directory or cancel? ~ change - cancel ~")
    ans = input()
    if ans == "change":
        load_ask3()
    elif ans == "cancel":
        start_ask()
    else:
        print("Sorry din't catch that can you repeat it?")
        load_ask2()

def load_ask3():
    global file_location

    print("What would you like to load?")
    file_location = input(file_location)
    load_ask1()


def loading():
    print("Loading file...")


def writing():
    global original_txt

    print("Please write what you would like me to interpret...")
    txt = input()
    print("Are you done? ~ yes - no  - cancel~")
    ans = input()
    if ans == "yes":
        txt = original_txt
    elif ans == "no":
        print("Okay continue...")
        writing1(txt)
    elif ans == "cancel":
        start_ask()
    else:
        print("Sorry din't catch that can you repeat it?")
        writing()

def writing1(txt):
    txt = input(txt)
    print("Are you done? ~ yes - no  - cancel~")
    ans = input()
    if ans == "yes":
        txt = original_txt
    elif ans == "no":
        print("Okay continue...")
        text = txt
        writing1(text)
    elif ans == "cancel":
        start_ask()
    else:
        print("Sorry din't catch that can you repeat it?")
        writing1()



start()