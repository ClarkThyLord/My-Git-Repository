import os.path

list = ["taco", "cheese"]
listLocation = "No Directory"
listName = "Untitled List"


def intro():
    print("Hello, I'm your shopping list, tell me what to do...")
    print("I can add  or remove items from the list, or tell you what items you have on the list...")


def ask():
    print("What would you like me to do add or remove items from the list, show you the list, save or load, or exit? ~ "
          "enter commands for list of commands ~")
    ans = input()
    # CHECK FOR COMMAND
    if ans == "about":
        intro()
        ask()

    elif ans == "commands":
        commands()

    elif ans == "add":
        add()

    elif ans == "remove":
        if not list:
            print("You have nothing to remove...")
            ask()
        else:
            remove()

    elif ans == "show":
        if not list:
            print("You have nothing to show...")
            ask()
        else:
            show()

    elif ans == "load":
        load()

    elif ans == "save":
        if not list:
            print("You have nothing to save...")
            ask()
        else:
            saveAsk()

    elif ans == "exit":
        exit()

    else:
        print("Sorry didn't catch that can you repeat it?")
        ask()

def commands():
    print("List of Commands:")
    print("about -  commands - add - remove - show - load - save - exit")
    ask()

def add():
    print("What would you like me to add? ~ enter never mind to go back ~")
    ans = input()
    if ans == "never mind":
        ask()
    if ans in list:
        print(ans + " is already in " + listName)
        add()
    else:
        new_item = ans
        confirm_add(new_item)


def confirm_add(new_item):
    print("Are you sure you want to add " + new_item + " to " + listName + "?")
    ans = input()
    if ans == "yes":
        print("Added " + new_item + " to the " + listName + "...")
        list.append(new_item)
        add()
    elif ans == "no":
        print("Okay, I didn't add " + new_item + " to " + listName + "...")
        add()
    elif ans == "never mind":
        print("Okay...")
        ask()
    else:
        print("Sorry didn't catch that can you repeat it?")
        confirm_add(new_item)


def remove():
    print("What would you like me to remove? ~ enter never mind to go back ~")
    ans = input()
    if ans == "never mind":
        ask()
    if ans in list:
        remove_item = ans
        confirm_remove(remove_item)
    else:
        print("Sorry there is no " + ans + " in " + listName)
        remove()


def confirm_remove(remove_item):
    print("Are you sure you want to remove " + remove_item + " from " + listName + "?")
    ans = input()
    if ans == "yes":
        print("I've removed " + remove_item + " from " + listName)
        list.remove(remove_item)
        remove()
    elif ans == "no":
        print("Okay, I didn't remove the " + remove_item + " from " + listName + "... ")
        remove()
    elif ans == "never mind":
        print("Okay...")
        ask()
    else:
        print("Sorry didn't catch that can you repeat it?")
        confirm_remove(remove_item)


def show():
    print("Let me show you " + listName + "...")
    print("-----| " + listName + " |-----")
    for i in list:
        print(" ~ " + i)
    print("---------------------------")
    print("That's all the items in " + listName + "...")
    ask()


def load():
    print("What list would you like to load?")


def save():
    print("Would you like to save this list?")
    ans = input()
    if ans == "yes":
        saveTo()

    elif ans == "no":
        saveAsk()

    else:
        print("Sorry didn't catch that can you repeat it?")
        save()


def saveAsk():
    print("Would you like me to save the list to " + listLocation + ", under " + listName)
    ans = input()
    if ans == "yes":
        filename = os.path.join(listLocation, listName + ".txt")
        savefile = open(filename, "w")

        savefile.write("-----| " + listName + " |-----")
        for i in list:
            savefile.write("\n ~ " + i)
        savefile.write("\n---------------------------")
        savefile.closed

        print("Will save the list to " + listLocation + ", under " + listName + ", once the program is closed...")
        quit()
    elif ans == "no":
        saveTo()
    else:
        print("Sorry didn't catch that can you repeat it?")
        saveAsk()


def saveTo():
    print("Where will you save the list?")
    listLocation = input()
    print("What will you name the list?")
    listName = input()

    filename = os.path.join(listLocation, listName + ".txt")
    savefile = open(filename, "w")

    savefile.write("-----| " + listName + " |-----")
    for i in list:
        savefile.write("\n ~ " + i)
    savefile.write("\n---------------------------")
    savefile.closed

    print("Will save the list to " + listLocation + ", under " + listName + ", once the program is closed...")
    quit()


def exit():
    print("Are you sure you want to exit? ~ all unsaved progress will be lost ~")
    ans = input()
    if ans == "yes":
        print("Goodbye;)")
    elif ans == "no":
        print("Ok then...")
        ask()
    else:
        print("Sorry didn't catch that can you repeat it?")
        exit()


def quit():
    print("Would you like to exit?")
    ans = input()
    if ans == "yes":
        print("Goodbye;)")
    elif ans == "no":
        print("Okay...")
        ask()
    else:
        print("Sorry didn't catch that can you repeat it?")
        quit()


intro()
ask()
