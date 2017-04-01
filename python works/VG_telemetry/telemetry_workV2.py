import gamelocker
from gamelocker.strings import pretty
import requests
import datetime
from PIL import Image

key = ""
api = gamelocker.Gamelocker(key).Vainglory()

# NOTICE
print("!!!WHEN TESTING TRY TO ONLY USE BLITZ, ANYTHING ELSE TAKES SEVERAL MINUTES TO PROCESS!!!")

# Transforms locations
def mapX(x):
    xC = 1242
    return x * 13.3 + xC


# Transforms locations
def mapY(y):
    yC = 317
    return y * 13.4 + yC


# Add a dot icon to the given img
def markDot(image, cords, color="grey"):
    """
    Mark a dot icon on the map.
    """

    try:

        # Size of image parts
        sizeX = 7
        sixeY = 7

        if color == "grey":  # Open the image for dot color grey
            dot = Image.open("imgs\dot_grey.png")

        elif color == "blue":  # Open the image for dot color blue
            dot = Image.open("imgs\dot_blue.png")

        elif color == "red":  # Open the image for dot color red
            dot = Image.open("imgs\dot_red.png")

        else:  # Open the image for dot color grey
            dot = Image.open("imgs\dot_grey.png")

        # Scale cords to map size
        x = mapX(cords[0])
        y = mapY(cords[2])

        # Top left corner cords
        x1 = int(x - sizeX)
        y1 = int(y - sixeY)
        # Bottom right corner cords
        x2 = int(x + sizeX)
        y2 = int(y + sixeY)

        # print("DOT:")
        # print("X1: " + str(x1) + " |Y1: " + str(y1) + " |X2: " + str(x2) + " |Y2: " + str(y2))
        # print("X Scale: " + str(x2 - x1) + " |Y Scale: " + str(y2 - y1))

        # kraken.show()
        image.paste(dot, (x1, y1, x2, y2), dot)

        return image

    except Exception as e:
        print("ERROR:\n" + str(e))

name = input("Name:")
if name == "":
    name = "ClarkthyLord"

days = input("Date Range:")
if days == "":
    days = 93

else:
    days = int(days)

game_mode = str(input("Game Mode:")).lower()
if game_mode == "" or game_mode == "any":
    game_mode = False

# DATE RANGE when FETCHING from MATCHES!!! example: {"filter[createdAt-start]": daterange, "filter[createdAt-end]": datenow, etc...}
datenow = datetime.date.today()
daterange = str(datenow - datetime.timedelta(days=days)) + "T00:00:00Z"  # Get the DATE RANGE to SEARCH from
# datenow = str(datetime.date.today()) + "T00:00:00Z"  # CURRENT DATE

# BUILD FILTER used to GET MATCHES
filter = {'filter[createdAt-start]': daterange, 'page[limit]': 1, 'filter[playerNames]': name, "sort": "-createdAt"}

if game_mode == False:
    pass

elif game_mode == "casual":
    filter["filter[gameMode]"] = "casual"

elif game_mode == "rank":
    filter["filter[gameMode]"] = "ranked"

elif game_mode == "royale":
    filter["filter[gameMode]"] = "casual_aral"

elif game_mode == "blitz":
    filter["filter[gameMode]"] = "blitz_pvp_ranked"

print("FILTER:   " + str(filter) + "\n")

matches = api.matches(filter)
match = matches[0]

print("MATCHES:   " + str(matches) + "\nMATCH:   " + str(match) + "\n")

for roster in match.rosters:
    roster_dict = dict(roster.to_dict())
    print("ROSTER:   " + str(roster_dict))
    # print("PARTICIPANTS:   " + str(roster.participants))
    for participant in roster.participants:
        print("PARTICIPANT NAME:   " + str(participant.player.name))
        print("PARTICIPANT:   " + str(participant.to_dict()))
        if participant.player.name == name:

            # Get the players hero
            actor = str(pretty(participant.actor)).replace("*", "")

            # Get the players side
            if roster_dict["attributes"]["stats"]["side"] == "left/blue":
                side = "Left"

            else:
                side = "Right"

            # Since we have the players info stop looping
            break

    print("\n")

print("ACTOR:   " + str(actor) + " | SIDE:   " + str(side))

# Get the url of telemetry
url = match.assets[0].url
print("URL:   " + str(url))

# Get the telemetry json
request = requests.get(url)
data = request.json()

# print("Telemetry JSON:   " + str(data))
print("Telemetry JSON:   Nope")
print("Size:   " + str(len(data)))


# # Open the image
# image = Image.open('imgs\map.png')
#
# errors = 0
# types = set([])
# for event in data:
#     try:
#         # # Get cords of event
#         # cords = event["payload"]["Position"]
#         #
#         # # Mark that image
#         # markDot(image, cords)
#
#         types.add(event["type"])
#
#     except:
#         errors += 1
#
# print("TYPES:   " + str(types))
# print("ERRORS:   " + str(errors) + "\nPOSSIBLE:   " + str(len(data) - errors))
#
# # Save the image
# image.save("imgs\map_1.png")
#
# # Close the image
# image.close()
#
# print("!!!DONE!!!")

key1 = data[0]
key2 = data[-1]

# API time
key_time1 = str(key1["time"])
print("Key One:   " + str(key1))
print("First Event Time:   " + str(key_time1))

key_time2 = str(key2["time"])
print("Key Two:   " + str(key2))
print("Last Event Time:   " + str(key_time2))

print("\n")

# Python time
key_time1 = datetime.datetime.strptime(key_time1, "%Y-%m-%dT%H:%M:%S%z")
print("Python Time 1:   " + str(key_time1))

key_time2 = datetime.datetime.strptime(key_time2, "%Y-%m-%dT%H:%M:%S%z")
print("Python Time 2:   " + str(key_time2))

print("\n")

time = (key_time2 - key_time1).seconds
print("Time:   " + str(time / 60).replace(".", ":"))

current_time = 1
event_timeline = {0: []}
for event in data:
    # Get the current even time relevant to first event time
    event_time = (datetime.datetime.strptime(event["time"], "%Y-%m-%dT%H:%M:%S%z") - key_time1).seconds / 60

    #FOR DEBUGGING
    print("\nEVENT:   " + str(event) + "\nEVENT TIME:   " + str(event_time).replace(".", ":"))
    # print("CURRENT EVENT TIME LINE:   " + str(event_timeline))
    if event_time >= current_time:
        print("XXX>   EVENT TIME:   " + str(event_time) + " IS GREATER THAN CURRENT TIME:   " + str(current_time) + "   <XXX")

        event_timeline[current_time] = []
        current_time += 1

    event_timeline[(current_time - 1)].append(event)

print("\n")

print("EVENT TIME LINE:   " + str(event_timeline))
print("SIZE OF EVENT TIME LINE:   " + str(len(event_timeline)))
total_events = 0
for event_group in event_timeline:
    print("EVENT " + str(event_group) + ":   " + str(len(event_timeline[event_group])))

    total_events += len(event_timeline[event_group])

print("CAPTURED:   " + str(total_events) + " \\ " + str(len(data)))


# Process the data into ta photo
current = 0
def processData():
    global event_timeline
    global current

    print("\nWhat would you like to do?\n~ next - process - back - exit ~")
    ans = str(input()).lower()

    if ans == "next":
        if (current + 1) not in event_timeline:
            print("Sorry this is the end of the line...")
            processData()

        else:
            current += 1
            print("You're in minute " + str(current) + " of the match!")
            processData()

    elif ans == "back":
        if (current - 1) not in event_timeline:
            print("Sorry this is the end of the line...")
            processData()

        else:
            current -= 1
            print("You're in minute " + str(current) + " of the match!")
            processData()

    elif ans == "process":
        # Open the image
        image = Image.open('imgs\map.png')

        errors = 0
        # types = set([])
        for event in event_timeline[current]:
            try:
                # Get cords of event
                cords = event["payload"]["Position"]

                # Mark that image
                markDot(image, cords)

                # types.add(event["type"])

            except:
                errors += 1

        # print("TYPES:   " + str(types))
        print("ERRORS:   " + str(errors) + "\nPOSSIBLE:   " + str(len(data) - errors))

        # Save the image
        image.save("imgs\map_" + str(current) + ".png")

        print("\nI've saved the image to imgs\map_" + str(current) + ".png...")

        processData()

        # Close the image
        image.close()

    elif ans == "exit":
        pass

    else:
        print("Didn't catch that sorry...")
        processData()

processData()

print("!!!DONE!!!")
