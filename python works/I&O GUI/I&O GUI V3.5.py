from tkinter import *

# GLOBAL VAR
STAGE = "STARTUP"
output = "Starting...\nGREEN is the System ~ BLUE is the User ~ RED is an Error"  # First text you see
lineA = 3.0 # CHANGE ACCORDING TO OUTPUT
lineB = 4.0 # CHANGE ACCORDING TO OUTPUT
T1 = 1
T2 = 1
T3 = 1


class GUI:

    # Create the GUI
    def __init__(self):
        global output

        # Local GUI VAR
        sizeX = 800  # X size of the window
        sizeY = 600  # Y size of the window
        posX = 0  # X position of the window
        posY = 0  # Y position of the window

        # Setting up the window
        self.window = Tk()
        self.window.title("I/0 GUI")
        self.window.wm_geometry("%dx%d+%d+%d" % (sizeX, sizeY, posX, posY))

        # Setting up the frames; first & second
        self.first = Frame(self.window)
        self.first.pack(anchor=NW, fill=BOTH, expand=YES)
        self.second = Frame(self.window)
        self.second.pack(side=BOTTOM, fill=X)

        # Setting up stuff for first frame
        self.output_box = Text(self.first)
        self.output_box.insert(INSERT, output)
        self.output_box.config(state=DISABLED)
        self.output_box.pack(side=LEFT, fill=BOTH, expand=YES)

        # PLACE A HORIZONTAL SCROLLBAR
        # self.scrollbar_X = Scrollbar(self.first, orient=HORIZONTAL, command=self.output_box.xview)
        # self.scrollbar_X.pack(side=BOTTOM, fill=X)
        # self.output_box.configure(xscrollcommand=self.scrollbar_X.set)

        # PLACE  A VERTICAL SCROLLBAR
        self.scrollbar_Y = Scrollbar(self.first, orient=VERTICAL, command=self.output_box.yview)
        self.scrollbar_Y.pack(side=RIGHT, fill=Y)
        self.output_box.configure(yscrollcommand=self.scrollbar_Y.set)

        # Setting up stuff for second frame
        self.input_box = Entry(self.second)
        self.input_box.bind("<Return>", self.send_0)
        self.input_box.pack(side=LEFT, fill=X, expand=YES)

        self.enter = Button(self.second, text="Enter", command=lambda: self.send_1(self.input_box.get()))
        self.enter.pack(side=RIGHT)

        # START
        self.startup()

        #RUN
        self.window.mainloop()


    # Send the input to be handled when Enter or Return is pressed
    def send_0(self, event):
        input = self.input_box.get()
        self.send_1(input)


    # Send the input to be handled when I click the button
    def send_1(self, user_input):
        self.input_box.delete(0, END)
        print("INPUT: " + user_input)
        if user_input != "":
            self.update(user_input, isinput=TRUE)
            self.handler(user_input)
        else:
            self.update("Nothing was entered...", iserror=TRUE)

    # Handle the input
    def handler(self, user_input):
        global STAGE

        # HANDLE THE INPUT
        if STAGE == "ASKB":
            self.askB(user_input)


    # Update the output
    def update(self, update, isinput=FALSE, isoutput=FALSE, iserror=FALSE):
        global lineA
        global lineB
        global T1
        global T2
        global T3

        if isinput == TRUE:
            print("UPDATING WITH: " + update)
            update = "\n" + str(update)

            self.output_box.config(state=NORMAL)
            self.output_box.insert(END, update)

            self.output_box.tag_add("input_tag" + str(T1), str(lineA), str(lineB))
            self.output_box.tag_config("input_tag" + str(T1), background="lightblue")
            print("ON LINE: " + str(lineA) + ", " + str(lineB) + "     FIRST TAG 1: #" + str(T1))
            lineA += 1.0
            lineB += 1.0
            T1 += 1

            self.output_box.config(state=DISABLED)
            self.output_box.see("end")
        elif isoutput == TRUE:
            print("UPDATING WITH: " + update)
            update = "\n" + str(update)

            self.output_box.config(state=NORMAL)
            self.output_box.insert(END, update)

            self.output_box.tag_add("output_tag" + str(T2), str(lineA), str(lineB))
            self.output_box.tag_config("output_tag" + str(T2), background="lightgreen")
            print("ON LINE: " + str(lineA) + ", " + str(lineB) + "     SECOND TAG 2: #" + str(T2))
            lineA += 1.0
            lineB += 1.0
            T2 += 1

            self.output_box.config(state=DISABLED)
            self.output_box.see("end")
        elif iserror == TRUE:
            print("UPDATING WITH: " + update)
            update = "\n" + str(update)

            self.output_box.config(state=NORMAL)
            self.output_box.insert(END, update)

            self.output_box.tag_add("error_tag" + str(T3), str(lineA), str(lineB))
            self.output_box.tag_config("error_tag" + str(T3), background="lightcoral")
            print("ON LINE: " + str(lineA) + ", " + str(lineB) + "     THIRD TAG: #" + str(T3))
            lineA += 1.0
            lineB += 1.0
            T3 += 1

            self.output_box.config(state=DISABLED)
            self.output_box.see("end")
        else:
            print("!!!HUGE ERROR!!!")


# HANDLERS**************************************************************************************************************

    # Say on startup
    def startup(self):
        global STAGE

        self.update("Welcome to the I/O program!!!", isoutput=TRUE)
        self.askA()


    # Example format QUESTION is followed  by "A" and RESULT is followed by "B"
    def askA(self):
        global STAGE

        STAGE = "ASKB"
        self.update("What would you like to do? ~ hello - exit ~", isoutput=TRUE)


    # Example format QUESTION is followed  by "A" and RESULT is followed by "B"
    def askB(self, ans):
        global STAGE

        if ans == "hello":
            self.update("Hi!!!", isoutput=TRUE)
            self.askA()
        elif ans == "exit":
            self.update("Shutting down...", isoutput=TRUE)
            self.EXIT()
        else:
            self.update("Sorry didn't catch that...", iserror=TRUE)
            self.askA()

    def EXIT(self):

        print("!!!EXIT!!!")
        exit()


frame = GUI()