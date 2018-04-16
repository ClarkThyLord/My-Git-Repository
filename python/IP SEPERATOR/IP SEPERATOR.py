from tkinter import *
import re
import os


output_text = "Give me the text..."
working_ips = []


class main:

    def __init__(self):
        global output_text

        self.window = Tk()
        self.window.title("Text to IP")

        self.side_1 = Frame(self.window)
        self.side_1.pack(side=TOP, fill=X)

        self.side_2 = Frame(self.window)
        self.side_2.pack(side=BOTTOM, fill=X)

        self.output = Label(self.side_1, anchor=NW, justify=LEFT, text=output_text)
        self.output.pack(side=LEFT, fill=X, expand=YES)

        self.input = Entry(self.side_2)
        self.input.pack(side=LEFT, fill=X, expand=YES)
        self.input.focus_set()

        self.enter = Button(self.side_2, text="Enter", command=lambda: self.send_input())
        self.enter.pack(side=LEFT)

        self.window.mainloop()

    def send_input(self):
        global output_text

        print("Sending...\n INPUT: \n" + self.input.get())
        output_text = output_text + "\n" + self.input.get()
        self.output.config(text=output_text)
        input = self.input.get()
        self.input.delete(0, 'end')
        self.handeler(input)

    def handeler(self, input):
        global output_text
        global working_ips

        #SPLIT THE IP
        ip = re.findall(r"(?::)[1-9].*(?::)", input)
        ip_list = []
        for i in ip:
            ip_list += re.findall(r"[1-9].*[1-9]", i)

        output_text += "\nIP LIST*******************************"
        for i in ip_list:

            print(i)
            output_text += "\n" + str(i)

        self.output.config(text=output_text)

        #PING THE IP
        for i in ip_list:
            test = os.system("ping " + i)
            print(test)

            if test == 0:
                print("TRUE******************************")

                working_ips += i

                output_text += "\nTRUE\nADDING " + str(i)

                self.output.config(text=output_text)

            elif test == 1:
                print("FALSE")
                output_text += "\nFALSE\nREMOVING" + str(i)

                self.output.config(text=output_text)

            else:
                print("ERROR")
                output_text += "\nERROR\nSHUTTING DOWN!!!"

                self.output.config(text=output_text)

        #LIST OF WORKING IPs
        for i in working_ips:
            print(working_ips)
            print(i)
            output_text += "\n" + str(working_ips)
            output_text += "\n" + str(i)

        self.output.config(text=output_text)



window = main()