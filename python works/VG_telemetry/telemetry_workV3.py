import gamelocker
from gamelocker.strings import pretty
import requests
import datetime
from PIL import Image

key = ""
api = gamelocker.Gamelocker(key).Vainglory()


# Transforms locations
def mapX(x):
    xC = 1242
    return x * 13.3 + xC


def mapY(y):
    yC = 317
    return y * 13.4 + yC


# Add a kraken icon to the given img
def markKraken(image, cords, color="grey"):
    """
    Mark a kraken icon on the map.
    """

    try:

        # Size of image parts
        sizeX = 22.5
        sixeY = 23.5

        if color == "grey":  # Open the image for kraken color grey
            kraken = Image.open("imgs\\telemetry_map\\kraken_grey.png")

        elif color == "blue":  # Open the image for kraken color blue
            kraken = Image.open("imgs\\telemetry_map\\kraken_blue.png")

        elif color == "red":  # Open the image for kraken color red
            kraken = Image.open("imgs\\telemetry_map\\kraken_red.png")

        else:  # Open the image for kraken color grey
            kraken = Image.open("imgs\\telemetry_map\\kraken_grey.png")

        # Scale cords to map size
        x = mapX(cords[0])
        y = mapY(cords[2])

        # Top left corner cords
        x1 = int(x - sizeX)
        y1 = int(y - sixeY)
        # Bottom right corner cords
        x2 = int(x + sizeX)
        y2 = int(y + sixeY)


        # print("KRAKEN:")
        # print("X1: " + str(x1) + " |Y1: " + str(y1) + " |X2: " + str(x2) + " |Y2: " + str(y2))
        # print("X Scale: " + str(x2 - x1) + " |Y Scale: " + str(y2 - y1))

        # kraken.show()
        image.paste(kraken, (x1, y1, x2, y2), kraken)

        # Close used img
        kraken.close()

        return image

    except Exception as e:
        print("KRAKEN MARK ERROR:\n" + str(e))


# Add a circle icon to the given img
def markCircle(image, cords, color="grey"):
    """
    Mark a circle icon on the map.
    """

    try:

        # Size of image parts
        sizeX = 16
        sixeY = 16

        if color == "grey":  # Open the image for circle color grey
            circle = Image.open("imgs\\telemetry_map\\circle_grey.png")

        elif color == "blue":  # Open the image for circle color blue
            circle = Image.open("imgs\\telemetry_map\\circle_blue.png")

        elif color == "red":  # Open the image for circle color red
            circle = Image.open("imgs\\telemetry_map\\circle_red.png")

        else:  # Open the image for circle color grey
            circle = Image.open("imgs\\telemetry_map\\circle_grey.png")

        # Scale cords to map size
        x = mapX(cords[0])
        y = mapY(cords[2])

        # Top left corner cords
        x1 = int(x - sizeX)
        y1 = int(y - sixeY)
        # Bottom right corner cords
        x2 = int(x + sizeX)
        y2 = int(y + sixeY)

        # print("CIRCLE:")
        # print("X1: " + str(x1) + " |Y1: " + str(y1) + " |X2: " + str(x2) + " |Y2: " + str(y2))
        # print("X Scale: " + str(x2 - x1) + " |Y Scale: " + str(y2 - y1))

        # kraken.show()
        image.paste(circle, (x1, y1, x2, y2), circle)

        # Close used img
        circle.close()

        return image

    except Exception as e:
        print("CIRCLE MARK ERROR:\n" + str(e))


# Add a crystal icon to the given img
def markCrystal(image, cords, color="grey"):
    """
    Mark a crystal icon on the map.
    """

    try:

        # Size of image parts
        sizeX = 27.5
        sixeY = 40

        if color == "grey":  # Open the image for crystal color grey
            crystal = Image.open("imgs\\telemetry_map\\crystal_grey.png")

        elif color == "blue":  # Open the image for crystal color blue
            crystal = Image.open("imgs\\telemetry_map\\crystal_blue.png")

        elif color == "red":  # Open the image for crystal color red
            crystal = Image.open("imgs\\telemetry_map\\crystal_red.png")

        else:  # Open the image for crystal color grey
            crystal = Image.open("imgs\\telemetry_map\\crystal_grey.png")

        # Scale cords to map size
        x = mapX(cords[0])
        y = mapY(cords[2])

        # Top left corner cords
        x1 = int(x - sizeX)
        y1 = int(y - sixeY)
        # Bottom right corner cords
        x2 = int(x + sizeX)
        y2 = int(y + sixeY)

        # print("CRYSTAL:")
        # print("X1: " + str(x1) + " |Y1: " + str(y1) + " |X2: " + str(x2) + " |Y2: " + str(y2))
        # print("X Scale: " + str(x2 - x1) + " |Y Scale: " + str(y2 - y1))

        # kraken.show()
        image.paste(crystal, (x1, y1, x2, y2), crystal)

        # Close used img
        crystal.close()

        return image

    except Exception as e:
        print("CRYSTAL MARK ERROR:\n" + str(e))


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
            dot = Image.open("imgs\\telemetry_map\\dot_grey.png")

        elif color == "blue":  # Open the image for dot color blue
            dot = Image.open("imgs\\telemetry_map\\dot_blue.png")

        elif color == "red":  # Open the image for dot color red
            dot = Image.open("imgs\\telemetry_map\\dot_red.png")

        else:  # Open the image for dot color grey
            dot = Image.open("imgs\\telemetry_map\\dot_grey.png")

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

        # Close used img
        dot.close()

        return image

    except Exception as e:
        print("DOT MARK ERROR:\n" + str(e))


# Add a flag icon to the given img
def markFlag(image, cords, color="grey"):
    """
    Mark a flag icon on the map.
    """

    try:

        # Size of image parts
        sizeX = 13
        sixeY = 13

        if color == "grey":  # Open the image for flag color grey
            flag = Image.open("imgs\\telemetry_map\\flag_grey.png")

        elif color == "blue":  # Open the image for flag color blue
            flag = Image.open("imgs\\telemetry_map\\flag_blue.png")

        elif color == "red":  # Open the image for flag color red
            flag = Image.open("imgs\\telemetry_map\\flag_red.png")

        else:  # Open the image for flag color grey
            flag = Image.open("imgs\\telemetry_map\\flag_grey.png")

        # Scale cords to map size
        x = mapX(cords[0])
        y = mapY(cords[2])

        # Top left corner cords
        x1 = int(x - sizeX)
        y1 = int(y - sixeY)
        # Bottom right corner cords
        x2 = int(x + sizeX)
        y2 = int(y + sixeY)

        # print("FLAG:")
        # print("X1: " + str(x1) + " |Y1: " + str(y1) + " |X2: " + str(x2) + " |Y2: " + str(y2))
        # print("X Scale: " + str(x2 - x1) + " |Y Scale: " + str(y2 - y1))

        # kraken.show()
        image.paste(flag, (x1, y1, x2, y2), flag)

        # Close used img
        flag.close()

        return image

    except Exception as e:
        print("FLAG MARK ERROR:\n" + str(e))


# Add a turret icon to the given img
def markTurret(image, cords, color="grey"):
    """
    Mark a turret icon on the map.
    """

    try:

        # Size of image parts
        sizeX = 18
        sixeY = 18

        if color == "grey":  # Open the image for turret color grey
            turret = Image.open("imgs\\telemetry_map\\turret_grey.png")

        elif color == "blue":  # Open the image for turret color blue
            turret = Image.open("imgs\\telemetry_map\\turret_blue.png")

        elif color == "red":  # Open the image for turret color red
            turret = Image.open("imgs\\telemetry_map\\turret_red.png")

        else:  # Open the image for turret color grey
            turret = Image.open("imgs\\telemetry_map\\turret_grey.png")

        # Scale cords to map size
        x = mapX(cords[0])
        y = mapY(cords[2])

        # Top left corner cords
        x1 = int(x - sizeX)
        y1 = int(y - sixeY)
        # Bottom right corner cords
        x2 = int(x + sizeX)
        y2 = int(y + sixeY)

        # print("TURRET:")
        # print("X1: " + str(x1) + " |Y1: " + str(y1) + " |X2: " + str(x2) + " |Y2: " + str(y2))
        # print("X Scale: " + str(x2 - x1) + " |Y Scale: " + str(y2 - y1))

        # kraken.show()
        image.paste(turret, (x1, y1, x2, y2), turret)

        # Close used img
        turret.close()

        return image

    except Exception as e:
        print("TURRET MARK ERROR:\n" + str(e))


# Add a triangle icon to the given img
def markTriangle(image, cords, color="grey"):
    """
    Mark a triangle icon on the map.
    """

    try:

        # Size of image parts
        sizeX = 11.5
        sixeY = 10

        if color == "grey":  # Open the image for triangle color grey
            triangle = Image.open("imgs\\telemetry_map\\triangle_grey.png")

        elif color == "blue":  # Open the image for triangle color blue
            triangle = Image.open("imgs\\telemetry_map\\triangle_blue.png")

        elif color == "red":  # Open the image for triangle color red
            triangle = Image.open("imgs\\telemetry_map\\triangle_red.png")

        else:  # Open the image for triangle color grey
            triangle = Image.open("imgs\\telemetry_map\\triangle_grey.png")

        # Scale cords to map size
        x = mapX(cords[0])
        y = mapY(cords[2])

        # Top left corner cords
        x1 = int(x - sizeX)
        y1 = int(y - sixeY)
        # Bottom right corner cords
        x2 = int(x + sizeX)
        y2 = int(y + sixeY)

        # print("TRIANGLE:")
        # print("X1: " + str(x1) + " |Y1: " + str(y1) + " |X2: " + str(x2) + " |Y2: " + str(y2))
        # print("X Scale: " + str(x2 - x1) + " |Y Scale: " + str(y2 - y1))

        # kraken.show()
        image.paste(triangle, (x1, y1, x2, y2), triangle)

        # Close used img
        triangle.close()

        return image

    except Exception as e:
        print("TRIANGLE MARK ERROR:\n" + str(e))


# Add a shop icon to the given img
def markShop(image, cords, color="grey"):
    """
    Mark a shop icon on the map.
    """

    try:

        # Size of image parts
        sizeX = 14.5
        sixeY = 13.5

        if color == "grey":  # Open the image for shop color grey
            shop = Image.open("imgs\\telemetry_map\\shop_grey.png")

        elif color == "blue":  # Open the image for shop color blue
            shop = Image.open("imgs\\telemetry_map\\shop_blue.png")

        elif color == "red":  # Open the image for shop color red
            shop = Image.open("imgs\\telemetry_map\\shop_red.png")

        else:  # Open the image for shop color grey
            shop = Image.open("imgs\\telemetry_map\\shop_grey.png")

        # Scale cords to map size
        x = mapX(cords[0])
        y = mapY(cords[2])

        # Top left corner cords
        x1 = int(x - sizeX)
        y1 = int(y - sixeY)
        # Bottom right corner cords
        x2 = int(x + sizeX)
        y2 = int(y + sixeY)

        # print("SHOP:")
        # print("X1: " + str(x1) + " |Y1: " + str(y1) + " |X2: " + str(x2) + " |Y2: " + str(y2))
        # print("X Scale: " + str(x2 - x1) + " |Y Scale: " + str(y2 - y1))

        # kraken.show()
        image.paste(shop, (x1, y1, x2, y2), shop)

        # Close used img
        shop.close()

        return image

    except Exception as e:
        print("SHOP MARK ERROR:\n" + str(e))


# Add a star icon to the given img
def markStar(image, cords, color="grey"):
    """
    Mark a star icon on the map.
    """

    try:

        # Size of image parts
        sizeX = 16
        sixeY = 16

        if color == "grey":  # Open the image for star color grey
            star = Image.open("imgs\\telemetry_map\\star_grey.png")

        elif color == "blue":  # Open the image for star color blue
            star = Image.open("imgs\\telemetry_map\\star_blue.png")

        elif color == "red":  # Open the image for star color red
            star = Image.open("imgs\\telemetry_map\\star_red.png")

        else:  # Open the image for star color grey
            star = Image.open("imgs\\telemetry_map\\star_grey.png")

        # Scale cords to map size
        x = mapX(cords[0])
        y = mapY(cords[2])

        # Top left corner cords
        x1 = int(x - sizeX)
        y1 = int(y - sixeY)
        # Bottom right corner cords
        x2 = int(x + sizeX)
        y2 = int(y + sixeY)

        # print("STAR:")
        # print("X1: " + str(x1) + " |Y1: " + str(y1) + " |X2: " + str(x2) + " |Y2: " + str(y2))
        # print("X Scale: " + str(x2 - x1) + " |Y Scale: " + str(y2 - y1))

        # kraken.show()
        image.paste(star, (x1, y1, x2, y2), star)

        # Close used img
        star.close()

        return image

    except Exception as e:
        print("STAR MARK ERROR:\n" + str(e))

# Clean hero name
def cleanHeroNameVG(hero_name):
    """
    Clean a hero's name
    """

    try:

        hero_name = str(hero_name).replace("*", "")  # Convert hero name to string to prevent errors

        # List of old hero names
        old_heroes = {

            "Hero009": "Krul",
            "Hero010": "Skaarf",
            "Hero016": "Rona",
            "Sayoc": "Taka"

        }

        # List of hero names
        heroes = [
            "Adagio",
            "Alpha",
            "Ardan",
            "Baron",
            "Blackfeather",
            "Catherine",
            "Celeste",
            "Flicker",
            "Fortress",
            "Glaive",
            "Gwen",
            "Krul",
            "Skaarf",
            "Rona",
            "Idris",
            "Joule",
            "Kestrel",
            "Koshka",
            "Lance",
            "Lyra",
            "Ozo",
            "Petal",
            "Phinn",
            "Reim",
            "Ringo",
            "Samuel",
            "SAW",
            "Taka",
            "Skye",
            "Vox",
            "Grumpjaw"
        ]

        if hero_name in old_heroes:

            # FOR DEBUGGING
            print("CLEAN OLD HERO NAME:\nOLD NAME:   " + str(hero_name) + " |NEW NAME:   " + str(old_heroes[hero_name]))

            hero_name = old_heroes[hero_name]

        if hero_name in heroes:

            # FOR DEBUGGING
            print("CLEAN HERO NAME:\nORIGINAL:   " + str(hero_name) + "RETURNING:   " + str(hero_name))

            return hero_name

        else:

            # FOR DEBUGGING
            print("CLEAN HERO NAME:\nORIGINAL:   " + str(hero_name) + "RETURNING:   Unkown")

            return "Unkown"

    except Exception as e:
        print("CLEAN HERO NAME ERROR:\n" + str(e))


# Add a hero icon to the given img
def markHero(image, cords, hero, translateX=0, translateY=0):
    """
    Mark a hero icon on the map.
    """

    try:

        # Size of image parts
        sizeX = 13
        sixeY = 13

        hero = cleanHeroNameVG(hero)

        # Open the hero icon
        hero = Image.open("imgs\\icons\\heros\\26x26\\" + str(hero) +".png")

        # Scale cords to map size
        x = mapX(cords[0]) + int(translateX)
        y = mapY(cords[2]) + int(translateY)

        # Top left corner cords
        x1 = int(x - sizeX)
        y1 = int(y - sixeY)
        # Bottom right corner cords
        x2 = int(x + sizeX)
        y2 = int(y + sixeY)

        print("HERO:")
        print("X1: " + str(x1) + " |Y1: " + str(y1) + " |X2: " + str(x2) + " |Y2: " + str(y2))
        print("X Scale: " + str(x2 - x1) + " |Y Scale: " + str(y2 - y1))

        # kraken.show()
        image.paste(hero, (x1, y1, x2, y2))

        # Close used img
        hero.close()

        return image

    except Exception as e:
        print("HERO MARK ERROR:\n" + str(e))


# Mark a hero kill to the given img
def markHeroKill(image, cords, color="grey", hero_1="Unkown", hero_2="Unkown"):
    """
    Mark a hero kill on the map.
    """

    try:

        # Size of image parts
        sizeX = 16
        sixeY = 16

        if color == "grey":  # Mark a circle for hero kill
            image = markCircle(image, cords, "grey")

        elif color == "blue":  # Mark a circle for hero kill
            image = markCircle(image, cords, "blue")

        elif color == "red":  # Mark a circle for hero kill
            image = markCircle(image, cords, "red")

        else:  # Mark a circle for hero kill
            image = markCircle(image, cords)

        # Mark the first hero
        image = markHero(image, cords, hero_1, 0, 17)

        # Mark the second hero
        image = markHero(image, cords, hero_2, 0, -17)

        return image

    except Exception as e:
        print("HERO KILL MARK ERROR:\n" + str(e))


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

# FOR DEBUGGING
print("FILTER:   " + str(filter) + "\n")

matches = api.matches(filter)
match = matches[0]

# FOR DEBUGGING
print("MATCHES:   " + str(matches) + "\nMATCH:   " + str(match) + "\n")

for roster in match.rosters:
    roster_dict = dict(roster.to_dict())
    # FOR DEBUGGING
    print("ROSTER:   " + str(roster_dict))
    # print("PARTICIPANTS:   " + str(roster.participants))
    for participant in roster.participants:
        # FOR DEBUGGING
        print("PARTICIPANT NAME:   " + str(participant.player.name))
        print("PARTICIPANT:   " + str(participant.to_dict()))
        if participant.player.name == name:

            # Get the players hero
            actor = str(pretty(participant.actor)).replace("*", "")

            # Get the players side
            if roster_dict["attributes"]["stats"]["side"] == "left/blue":
                side = "Left"
                side_e = "Right"

            else:
                side = "Right"
                side_e = "Left"

            # Since we have the players info stop looping
            break

    print("\n")

# FOR DEBUGGING
print("ACTOR:   " + str(actor) + " | SIDE:   " + str(side) + " | SIDE ENEMY:   " + str(side_e))

# Get the url of telemetry
url = match.assets[0].url

# FOR DEBUGGING
print("URL:   " + str(url))

# Get the telemetry json
request = requests.get(url)
data = request.json()

# FOR DEBUGGING
# print("Telemetry JSON:   " + str(data))
print("Telemetry JSON:   Nope")
print("Size:   " + str(len(data)))

# exit()

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
key_time2 = str(key2["time"])

# FOR DEBUGGING
print("Key One:   " + str(key1))
print("First Event Time:   " + str(key_time1))
print("Key Two:   " + str(key2))
print("Last Event Time:   " + str(key_time2))


# Python time
key_time1 = datetime.datetime.strptime(key_time1, "%Y-%m-%dT%H:%M:%S%z")
key_time2 = datetime.datetime.strptime(key_time2, "%Y-%m-%dT%H:%M:%S%z")

# FOR DEBUGGING
print("\n")
print("Python Time 1:   " + str(key_time1))
print("Python Time 2:   " + str(key_time2))

time = (key_time2 - key_time1).seconds

# FOR DEBUGGING
print("\n")
print("Match Time:   " + str(time / 60).replace(".", ":"))

# current_time = 1
# event_timeline = {0: []}
# for event in data:
#
#     # Check if event is relevant
#     if event["type"] == "LevelUp" or event["type"] == "PlayerFirstSpawn" or event["type"] == "LearnAbility" or event["type"] == "GoldFromTowerKill" or event["type"] == "GoldFromGoldMine" or event["type"] == "GoldFromKrakenKill" or event["type"] == "DealDamage" or event["type"] == "SellItem" or event["type"] == "EarnXP":
#         pass
#
#     else:
#         # Get the current even time relevant to first event time
#         event_time = (datetime.datetime.strptime(event["time"], "%Y-%m-%dT%H:%M:%S%z") - key_time1).seconds / 60
#
#         # FOR DEBUGGING
#         print("\nEVENT:   " + str(event) + "\nEVENT TIME:   " + str(event_time).replace(".", ":"))
#         # print("CURRENT EVENT TIME LINE:   " + str(event_timeline))
#         if event_time >= current_time:
#             print("XXX>   EVENT TIME:   " + str(event_time) + " IS GREATER THAN CURRENT TIME:   " + str(current_time) + "   <XXX")
#
#             event_timeline[current_time] = []
#             current_time += 1
#
#         event_timeline[(current_time - 1)].append(event)
#
# print("\n")
#
# print("EVENT TIME LINE:   " + str(event_timeline))
# print("SIZE OF EVENT TIME LINE:   " + str(len(event_timeline)))
# total_events = 0
# for event_group in event_timeline:
#     print("EVENT " + str(event_group) + ":   " + str(len(event_timeline[event_group])))
#
#     total_events += len(event_timeline[event_group])
#
# print("CAPTURED:   " + str(total_events) + " \\ " + str(len(data)))


# Process the data into a image
def processData():
    global actor
    global side
    global side_e

    print("\nWhat would you like to do?\n~ process - exit ~")
    ans = str(input()).lower()

    if ans == "process":
        # Open the image
        image = Image.open('imgs\\telemetry_map\map.png')

        errors = 0
        types = set([])
        NPC = 0
        ABI_I = 0
        ACTOR = 0
        BUY = 0
        ABI_H = 0
        for event in data:
            try:

                # Check if event is relevant | "UseAbility", "BuyItem", "UseItemAbility" <-- able to plot but not relevant!
                if event["type"] in ["LevelUp", "PlayerFirstSpawn", "LearnAbility", "GoldFromTowerKill", "GoldFromGoldMine", "GoldFromKrakenKill", "DealDamage", "SellItem", "EarnXP", "UseAbility", "BuyItem", "UseItemAbility"]:
                    pass

                elif event["type"] == "KillActor":
                    ACTOR += 1

                    if event["payload"]["Team"] == side:
                        # Get cords
                        cords = event["payload"]["Position"]

                        # If it's a hero kill mark hero kill
                        if event["payload"]["TargetIsHero"] == 1:

                            # Get the killer hero
                            hero_1 = event["payload"]["Actor"]

                            # Get the hero killed
                            hero_2 = event["payload"]["Killed"]

                            # FOR DEBUGGING
                            print("KILLER:   " + str(hero_1) + " |KILLED:   " + str(hero_2))

                            # Mark hero kill for hero kill
                            markHeroKill(image, cords, "blue", hero_1, hero_2)

                        # If it's a turret mark a turret
                        elif event["payload"]["Killed"] in ["*Turret*", "*VainTurret*"]:
                            # Mark turret
                            image = markTurret(image, cords, "blue")

                        # If it's a gold or crystal miner mark a flag
                        elif event["payload"]["Killed"] in ["*JungleMinion_GoldMiner*", "*JungleMinion_CrystalMiner*"]:
                            # Mark flag
                            image = markFlag(image, cords, "blue")

                        # If it's a kraken mark a kraken
                        elif event["payload"]["Killed"] in ["*Kraken_Captured*", "*Kraken_Jungle*"]:
                            # Mark kraken capture
                            image = markKraken(image, cords, "blue")

                        # If it's a vain crystal mark a crystal
                        elif event["payload"]["Killed"] in ["*VainCrystalAway*", "*VainCrystalHome*"]:
                            # Mark crystal
                            image = markCrystal(image, cords, "blue")

                        # If it's nothing above mark a dot
                        else:
                            # Mark dot
                            image = markDot(image, cords, "blue")

                    elif event["payload"]["Team"] == side_e:
                        # Get cords
                        cords = event["payload"]["Position"]

                        # If it's a hero mark circle
                        if event["payload"]["TargetIsHero"] == 1:

                            # Get the killer hero
                            hero_1 = event["payload"]["Actor"]

                            # Get the hero killed
                            hero_2 = event["payload"]["Killed"]

                            # FOR DEBUGGING
                            print("KILLER:   " + str(hero_1) + " |KILLED:   " + str(hero_2))

                            # Mark hero kill for hero kill
                            markHeroKill(image, cords, "red", hero_1, hero_2)

                        # If it's a turret mark a turret
                        elif event["payload"]["Killed"] in ["*Turret*", "*VainTurret*"]:
                            # Mark turret
                            image = markTurret(image, cords, "red")

                        # If it's a gold or crystal miner mark a flag
                        elif event["payload"]["Killed"] in ["*JungleMinion_GoldMiner*", "*JungleMinion_CrystalMiner*"]:
                            # Mark flag
                            image = markFlag(image, cords, "red")

                        # If it's a kraken mark a kraken
                        elif event["payload"]["Killed"] in ["*Kraken_Captured*", "*Kraken_Jungle*"]:
                            # Mark kraken capture
                            image = markKraken(image, cords, "red")

                        # If it's a vain crystal mark a crystal
                        elif event["payload"]["Killed"] in ["*VainCrystalAway*", "*VainCrystalHome*"]:
                            # Mark crystal
                            image = markCrystal(image, cords, "red")

                        # If it's nothing above mark a dot
                        else:
                            # Mark dot
                            image = markDot(image, cords, "red")

                    else:
                        # Get cords
                        cords = event["payload"]["Position"]

                        # If it's a hero mark circle
                        if event["payload"]["TargetIsHero"] == 1:

                            # Get the killer hero
                            hero_1 = event["payload"]["Actor"]

                            # Get the hero killed
                            hero_2 = event["payload"]["Killed"]

                            # FOR DEBUGGING
                            print("KILLER:   " + str(hero_1) + " |KILLED:   " + str(hero_2))

                            # Mark hero kill for hero kill
                            markHeroKill(image, cords, "grey", hero_1, hero_2)

                        # If it's a turret mark a turret
                        elif event["payload"]["Killed"] in ["*Turret*", "*VainTurret*"]:
                            # Mark turret
                            image = markTurret(image, cords)

                        # If it's a gold or crystal miner mark a flag
                        elif event["payload"]["Killed"] in ["*JungleMinion_GoldMiner*", "*JungleMinion_CrystalMiner*"]:
                            # Mark flag
                            image = markFlag(image, cords)

                        # If it's a kraken mark a kraken
                        elif event["payload"]["Killed"] in ["*Kraken_Captured*", "*Kraken_Jungle*"]:
                            # Mark kraken capture
                            image = markKraken(image, cords)

                        # If it's a vain crystal mark a crystal
                        elif event["payload"]["Killed"] in ["*VainCrystalAway*", "*VainCrystalHome*"]:
                            # Mark crystal
                            image = markCrystal(image, cords)

                        # If it's nothing above mark a dot
                        else:
                            # Mark dot
                            image = markDot(image, cords)

                # Marks whenever a npc was kills
                elif event["type"] == "NPCkillNPC":
                    NPC += 1

                    if event["payload"]["Team"] == side:
                        # Get cords
                        cords = event["payload"]["Position"]

                        # If it's a hero mark circle
                        if event["payload"]["TargetIsHero"] == 1:

                            # Get the killer hero
                            hero_1 = event["payload"]["Actor"]

                            # Get the hero killed
                            hero_2 = event["payload"]["Killed"]

                            # FOR DEBUGGING
                            print("KILLER:   " + str(hero_1) + " |KILLED:   " + str(hero_2))

                            # Mark hero kill for hero kill
                            markHeroKill(image, cords, "blue", hero_1, hero_2)

                        # If it's a turret mark a turret
                        elif event["payload"]["Killed"] in ["*Turret*", "*VainTurret*"]:
                            # Mark turret
                            image = markTurret(image, cords, "blue")

                        # If it's a gold or crystal miner mark a flag
                        elif event["payload"]["Killed"] in ["*JungleMinion_GoldMiner*", "*JungleMinion_CrystalMiner*"]:
                            # Mark flag
                            image = markFlag(image, cords, "blue")

                        # If it's a kraken mark a kraken
                        elif event["payload"]["Killed"] in ["*Kraken_Captured*", "*Kraken_Jungle*"]:
                            # Mark kraken capture
                            image = markKraken(image, cords, "blue")

                        # If it's a vain crystal mark a crystal
                        elif event["payload"]["Killed"] in ["*VainCrystalAway*", "*VainCrystalHome*"]:
                            # Mark crystal
                            image = markCrystal(image, cords, "blue")

                        # If it's nothing above mark a dot
                        else:
                            # Mark dot
                            image = markDot(image, cords, "blue")

                    elif event["payload"]["Team"] == side_e:
                        # Get cords
                        cords = event["payload"]["Position"]

                        # If it's a hero mark circle
                        if event["payload"]["TargetIsHero"] == 1:

                            # Get the killer hero
                            hero_1 = event["payload"]["Actor"]

                            # Get the hero killed
                            hero_2 = event["payload"]["Killed"]

                            # FOR DEBUGGING
                            print("KILLER:   " + str(hero_1) + " |KILLED:   " + str(hero_2))

                            # Mark hero kill for hero kill
                            markHeroKill(image, cords, "red", hero_1, hero_2)

                        # If it's a turret mark a turret
                        elif event["payload"]["Killed"] in ["*Turret*", "*VainTurret*"]:
                            # Mark turret
                            image = markTurret(image, cords, "red")

                        # If it's a gold or crystal miner mark a flag
                        elif event["payload"]["Killed"] in ["*JungleMinion_GoldMiner*", "*JungleMinion_CrystalMiner*"]:
                            # Mark flag
                            image = markFlag(image, cords, "red")

                        # If it's a kraken mark a kraken
                        elif event["payload"]["Killed"] in ["*Kraken_Captured*", "*Kraken_Jungle*"]:
                            # Mark kraken capture
                            image = markKraken(image, cords, "red")

                        # If it's a vain crystal mark a crystal
                        elif event["payload"]["Killed"] in ["*VainCrystalAway*", "*VainCrystalHome*"]:
                            # Mark crystal
                            image = markCrystal(image, cords, "red")

                        # If it's nothing above mark a dot
                        else:
                            # Mark dot
                            image = markDot(image, cords, "red")

                    else:
                        # Get cords
                        cords = event["payload"]["Position"]

                        # If it's a hero mark circle
                        if event["payload"]["TargetIsHero"] == 1:

                            # Get the killer hero
                            hero_1 = event["payload"]["Actor"]

                            # Get the hero killed
                            hero_2 = event["payload"]["Killed"]

                            # FOR DEBUGGING
                            print("KILLER:   " + str(hero_1) + " |KILLED:   " + str(hero_2))

                            # Mark hero kill for hero kill
                            markHeroKill(image, cords, "grey", hero_1, hero_2)

                        # If it's a turret mark a turret
                        elif event["payload"]["Killed"] in ["*Turret*", "*VainTurret*"]:
                            # Mark turret
                            image = markTurret(image, cords)

                        # If it's a gold or crystal miner mark a flag
                        elif event["payload"]["Killed"] in ["*JungleMinion_GoldMiner*", "*JungleMinion_CrystalMiner*"]:
                            # Mark flag
                            image = markFlag(image, cords)

                        # If it's a kraken mark a kraken
                        elif event["payload"]["Killed"] in ["*Kraken_Captured*", "*Kraken_Jungle*"]:
                            # Mark kraken capture
                            image = markKraken(image, cords)

                        # If it's a vain crystal mark a crystal
                        elif event["payload"]["Killed"] in ["*VainCrystalAway*", "*VainCrystalHome*"]:
                            # Mark crystal
                            image = markCrystal(image, cords)

                        # If it's nothing above mark a dot
                        else:
                            # Mark dot
                            image = markDot(image, cords)

                # elif event["type"] == "UseItemAbility":
                #     ABI_I += 1
                #
                #     if event["payload"]["Team"] == side:
                #         # Get cords
                #         cords = event["payload"]["Position"]
                #
                #         # Mark triangle for use of item ability
                #         markTriangle(image, cords, "blue")
                #
                #     elif event["payload"]["Team"] == side_e:
                #         # Get cords
                #         cords = event["payload"]["Position"]
                #
                #         # Mark triangle for use of item ability
                #         markTriangle(image, cords, "blue")
                #
                #     else:
                #         # Get cords
                #         cords = event["payload"]["Position"]
                #
                #         # Mark triangle for use of item ability
                #         markTriangle(image, cords, "blue")
                #
                # elif event["type"] == "BuyItem":
                #     BUY += 1
                #
                #     if event["payload"]["Team"] == side:
                #         # Get cords
                #         cords = event["payload"]["Position"]
                #
                #         # Mark a shop for buy
                #         image = markShop(image, cords, "blue")
                #
                #     elif event["payload"]["Team"] == side_e:
                #         # Get cords
                #         cords = event["payload"]["Position"]
                #
                #         # Mark a shop for buy
                #         image = markShop(image, cords, "red")
                #
                #     else:
                #         # Get cords
                #         cords = event["payload"]["Position"]
                #
                #         # Mark a shop for buy
                #         image = markShop(image, cords)
                #
                # elif event["type"] == "UseAbility":
                #     ABI_H += 1
                #
                #     if event["payload"]["Team"] == side:
                #         # Get cords
                #         cords = event["payload"]["Position"]
                #
                #         # Mark a star for hero ability use
                #         image = markStar(image, cords, "blue")
                #
                #     elif event["payload"]["Team"] == side_e:
                #         # Get cords
                #         cords = event["payload"]["Position"]
                #
                #         # Mark a star for hero ability use
                #         image = markStar(image, cords, "red")
                #
                #     else:
                #         # Get cords
                #         cords = event["payload"]["Position"]
                #
                #         # Mark a star for hero ability use
                #         image = markStar(image, cords)
                #
                # # Get cords of event
                # cords = event["payload"]["Position"]
                #
                # # Mark that image
                # markDot(image, cords)
                #
                # types.add(event["type"])

            except:
                types.add(event["type"])
                errors += 1

        # FOR DEBUGGING
        print("<--\nEVENTS:\nKILL ACTOR:   " + str(ACTOR) + "\nNPC:   " + str(NPC) + "\nITEM ABILITY:   " + str(ABI_I) + "\nBUY:   " + str(BUY) + "\nHERO ABILITY:   " + str(ABI_H) + "\n-->")

        # Save the image
        image.save("imgs\\telemetry_map\\map_master.png")

        # Close the image
        image.close()

        print("\nI've saved the image to imgs\map_master.png...")

        processData()

    elif ans == "exit":
        pass

    else:
        print("Didn't catch that sorry...")
        processData()

processData()

print("!!!DONE!!!")
