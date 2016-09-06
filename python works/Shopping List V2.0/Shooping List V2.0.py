from tkinter import *

list = {"Taco Shells": "2", "Yellow Cheese Brick": "1"}
output_text = "Hello, I'm your shopping list, tell me what to do...\nI can add  or remove items from the list, or " \
              "tell you what items you have on the list...\nWhat would you like me to do add or remove items from " \
              "the list, show you the list, save or load, or exit? ~ enter commands for list of commands ~"
location = "ask"

class main:

    def __init__(self):

        global output_text

        self.window = Tk()
        self.window.title("Shopping List")

        self.side_1 = Frame(self.window)
        self.side_1.pack(side=TOP, fill=X)

        self.side_2 = Frame(self.window)
        self.side_2.pack(side=BOTTOM, fill=X)

        self.output = Label(self.side_1, anchor=NW, justify=LEFT, text=output_text)
        self.output.pack(side=LEFT, fill=X, expand=YES)

        self.input = Entry(self.side_2)
        self.input.pack(side=LEFT, fill=X, expand=YES)
        self.input.focus_set()

        self.enter = Button(self.side_2, text="Enter", command=lambda: self.send())
        self.enter.pack(side=LEFT)

        self.window.mainloop()

    def send(self):
        global output_text

        print("Sending...\n INPUT: " + self.input.get())
        output_text = output_text + "\n" + self.input.get()
        self.output.config(text=output_text)
        input = self.input.get()
        self.input.delete(0, 'end')
        self.handeler(input)


    def handeler(self, input):
        global list
        global output_text
        global location

        print("PROCESSING INPUT ")

        if location == "ask":
            print("RUNNING: ask")
            if input == "commands":
                print("RUNNING: commands")
                output_text += "\ncommands -  about - add - remove - show - load - save - exit\nWhat " \
                               "would you like me to do add or remove items from the list, show you " \
                               "the list, save or load, or exit? ~ enter commands for list of commands ~"
                self.output.config(text=output_text)
            elif input == "about":
                print("RUNNING: about")
                output_text += "\nHello, I'm your shopping list, tell me what to do...\nI can add  or " \
                               "remove items from the list, or tell you what items you have on the list..."
                self.output.config(text=output_text)
                self.ask()
            elif input == "add":
                print("RUNNING: add")
                output_text += "\n"
                self.output.config(text=output_text)
            elif input == "remove":
                print("RUNNING: remove")
                output_text += "\n"
                self.output.config(text=output_text)
            elif input == "show":
                print("RUNNING: show")
                if not list:
                    print("EMPTY LIST")
                    output_text += "\nThe list is empty....\nWhat would you like me to do add or remove items from " \
                                   "the list, show you the list, save or load, or exit? ~ enter commands for list " \
                                   "of commands ~"
                    self.output.config(text=output_text)
                else:
                    output_text += "\nLet me show you the list...\n----------LIST----------"
                    for i, n in list.items():
                        output_text += "\n" + str(i) + " X " + str(n)
                    output_text += "\n------------------------"
                    self.output.config(text=output_text)
                    self.ask()
            elif input == "load":
                print("RUNNING: load")
                output_text += "\n"
                self.output.config(text=output_text)
            elif input == "save":
                print("RUNNING: save")
                output_text += "\n"
                self.output.config(text=output_text)
            elif input == "exit":
                print("RUNNING: exit")
                output_text += "\n"
                self.output.config(text=output_text)
            else:
                print("RUNNING: else")
                output_text += "\nSorry didn't catch that can you repeat it?"
                self.output.config(text=output_text)

    def ask(self):
        print("RUNNING: asking")
        global output_text
        output_text += "\nWhat would you like me to do add or remove items from the list, show you the list, save " \
                       "or load, or exit? ~ enter commands for list of commands ~"
        self.output.config(text=output_text)




main_obj = main()