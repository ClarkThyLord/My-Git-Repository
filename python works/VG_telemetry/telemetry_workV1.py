#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Wed Mar 29 22:10:16 2017

@author: phypoh
"""

from PIL import Image


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
            kraken = Image.open("imgs\kraken_grey.png")

        elif color == "blue":  # Open the image for kraken color blue
            kraken = Image.open("imgs\kraken_blue.png")

        elif color == "red":  # Open the image for kraken color red
            kraken = Image.open("imgs\kraken_red.png")

        else:  # Open the image for kraken color grey
            kraken = Image.open("imgs\kraken_grey.png")

        # Scale cords to map size
        x = mapX(cords[0])
        y = mapY(cords[2])

        # Top left corner cords
        x1 = int(x - sizeX)
        y1 = int(y - sixeY)
        # Bottom right corner cords
        x2 = int(x + sizeX)
        y2 = int(y + sixeY)


        print("KRAKEN:")
        print("X1: " + str(x1) + " |Y1: " + str(y1) + " |X2: " + str(x2) + " |Y2: " + str(y2))
        print("X Scale: " + str(x2 - x1) + " |Y Scale: " + str(y2 - y1))

        # kraken.show()
        image.paste(kraken, (x1, y1, x2, y2), kraken)

        return image

    except Exception as e:
        print("ERROR:\n" + str(e))


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
            circle = Image.open("imgs\circle_grey.png")

        elif color == "blue":  # Open the image for circle color blue
            circle = Image.open("imgs\circle_blue.png")

        elif color == "red":  # Open the image for circle color red
            circle = Image.open("imgs\circle_red.png")

        else:  # Open the image for circle color grey
            circle = Image.open("imgs\circle_grey.png")

        # Scale cords to map size
        x = mapX(cords[0])
        y = mapY(cords[2])

        # Top left corner cords
        x1 = int(x - sizeX)
        y1 = int(y - sixeY)
        # Bottom right corner cords
        x2 = int(x + sizeX)
        y2 = int(y + sixeY)

        print("CIRCLE:")
        print("X1: " + str(x1) + " |Y1: " + str(y1) + " |X2: " + str(x2) + " |Y2: " + str(y2))
        print("X Scale: " + str(x2 - x1) + " |Y Scale: " + str(y2 - y1))

        # kraken.show()
        image.paste(circle, (x1, y1, x2, y2), circle)

        return image

    except Exception as e:
        print("ERROR:\n" + str(e))


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
            crystal = Image.open("imgs\crystal_grey.png")

        elif color == "blue":  # Open the image for crystal color blue
            crystal = Image.open("imgs\crystal_blue.png")

        elif color == "red":  # Open the image for crystal color red
            crystal = Image.open("imgs\crystal_red.png")

        else:  # Open the image for crystal color grey
            crystal = Image.open("imgs\crystal_grey.png")

        # Scale cords to map size
        x = mapX(cords[0])
        y = mapY(cords[2])

        # Top left corner cords
        x1 = int(x - sizeX)
        y1 = int(y - sixeY)
        # Bottom right corner cords
        x2 = int(x + sizeX)
        y2 = int(y + sixeY)

        print("CRYSTAL:")
        print("X1: " + str(x1) + " |Y1: " + str(y1) + " |X2: " + str(x2) + " |Y2: " + str(y2))
        print("X Scale: " + str(x2 - x1) + " |Y Scale: " + str(y2 - y1))

        # kraken.show()
        image.paste(crystal, (x1, y1, x2, y2), crystal)

        return image

    except Exception as e:
        print("ERROR:\n" + str(e))


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

        print("DOT:")
        print("X1: " + str(x1) + " |Y1: " + str(y1) + " |X2: " + str(x2) + " |Y2: " + str(y2))
        print("X Scale: " + str(x2 - x1) + " |Y Scale: " + str(y2 - y1))

        # kraken.show()
        image.paste(dot, (x1, y1, x2, y2), dot)

        return image

    except Exception as e:
        print("ERROR:\n" + str(e))


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
            flag = Image.open("imgs\\flag_grey.png")

        elif color == "blue":  # Open the image for flag color blue
            flag = Image.open("imgs\\flag_blue.png")

        elif color == "red":  # Open the image for flag color red
            flag = Image.open("imgs\\flag_red.png")

        else:  # Open the image for flag color grey
            flag = Image.open("imgs\\flag_grey.png")

        # Scale cords to map size
        x = mapX(cords[0])
        y = mapY(cords[2])

        # Top left corner cords
        x1 = int(x - sizeX)
        y1 = int(y - sixeY)
        # Bottom right corner cords
        x2 = int(x + sizeX)
        y2 = int(y + sixeY)

        print("FLAG:")
        print("X1: " + str(x1) + " |Y1: " + str(y1) + " |X2: " + str(x2) + " |Y2: " + str(y2))
        print("X Scale: " + str(x2 - x1) + " |Y Scale: " + str(y2 - y1))

        # kraken.show()
        image.paste(flag, (x1, y1, x2, y2), flag)

        return image

    except Exception as e:
        print("ERROR:\n" + str(e))


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
            turret = Image.open("imgs\\turret_grey.png")

        elif color == "blue":  # Open the image for turret color blue
            turret = Image.open("imgs\\turret_blue.png")

        elif color == "red":  # Open the image for turret color red
            turret = Image.open("imgs\\turret_red.png")

        else:  # Open the image for turret color grey
            turret = Image.open("imgs\\turret_grey.png")

        # Scale cords to map size
        x = mapX(cords[0])
        y = mapY(cords[2])

        # Top left corner cords
        x1 = int(x - sizeX)
        y1 = int(y - sixeY)
        # Bottom right corner cords
        x2 = int(x + sizeX)
        y2 = int(y + sixeY)

        print("TURRET:")
        print("X1: " + str(x1) + " |Y1: " + str(y1) + " |X2: " + str(x2) + " |Y2: " + str(y2))
        print("X Scale: " + str(x2 - x1) + " |Y Scale: " + str(y2 - y1))

        # kraken.show()
        image.paste(turret, (x1, y1, x2, y2), turret)

        return image

    except Exception as e:
        print("ERROR:\n" + str(e))


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
            triangle = Image.open("imgs\\triangle_grey.png")

        elif color == "blue":  # Open the image for triangle color blue
            triangle = Image.open("imgs\\triangle_blue.png")

        elif color == "red":  # Open the image for triangle color red
            triangle = Image.open("imgs\\triangle_red.png")

        else:  # Open the image for triangle color grey
            triangle = Image.open("imgs\\triangle_grey.png")

        # Scale cords to map size
        x = mapX(cords[0])
        y = mapY(cords[2])

        # Top left corner cords
        x1 = int(x - sizeX)
        y1 = int(y - sixeY)
        # Bottom right corner cords
        x2 = int(x + sizeX)
        y2 = int(y + sixeY)

        print("TRIANGLE:")
        print("X1: " + str(x1) + " |Y1: " + str(y1) + " |X2: " + str(x2) + " |Y2: " + str(y2))
        print("X Scale: " + str(x2 - x1) + " |Y Scale: " + str(y2 - y1))

        # kraken.show()
        image.paste(triangle, (x1, y1, x2, y2), triangle)

        return image

    except Exception as e:
        print("ERROR:\n" + str(e))


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
            shop = Image.open("imgs\\shop_grey.png")

        elif color == "blue":  # Open the image for shop color blue
            shop = Image.open("imgs\\shop_blue.png")

        elif color == "red":  # Open the image for shop color red
            shop = Image.open("imgs\\shop_red.png")

        else:  # Open the image for shop color grey
            shop = Image.open("imgs\\shop_grey.png")

        # Scale cords to map size
        x = mapX(cords[0])
        y = mapY(cords[2])

        # Top left corner cords
        x1 = int(x - sizeX)
        y1 = int(y - sixeY)
        # Bottom right corner cords
        x2 = int(x + sizeX)
        y2 = int(y + sixeY)

        print("X1: " + str(x1) + " |Y1: " + str(y1) + " |X2: " + str(x2) + " |Y2: " + str(y2))
        print("X Scale: " + str(x2 - x1) + " |Y Scale: " + str(y2 - y1))

        # kraken.show()
        image.paste(shop, (x1, y1, x2, y2), shop)

        return image

    except Exception as e:
        print("ERROR:\n" + str(e))


# For debugging/testing purporses. Writes the telemetry into a txt file and saves it.
def writeFile(tele):
    filename = "tele.txt"
    text_file = open(filename, "w")
    text_file.write(str(tele))
    text_file.close()


# If this file is executable run this
if __name__ == "__main__":
    """
    Test to see if map transformations are correct
    """

    # Open the image
    image = Image.open('imgs\map.png')

    # Points used for testing
    # keyLocations = [
    #     (-88.50, 0.89, 2.00),  # Base Shop
    #     (-76.12, 0.00, 19.90),  # Vain
    #     (-75.48, 0.00, 11.96),  # Turrets
    #     (-68.59, 0.00, 19.97),
    #     (-54.00, 0.00, 2.92),
    #     # (0.00, 0.00, 23.60)  # Kraken
    #                ]
    #
    # for spot in keyLocations:
    #     image = markCross(image, spot)

    # Special creatures
    image = markKraken(image, (0.00, 0.00, 23.60))  # Kraken\Gold Miner cords(grey)
    image = markFlag(image, (-35.19, 0.00, 36.03), "red")  # Left side Crystal Miner(red)
    image = markFlag(image, (35.20, 0.00, 35.87), "blue")  # Right side Crystal Miner(blue)

    # Shops
    image = markShop(image, (-88.50, 0.89, 2.00), "red")  # Left side shop(red)
    image = markShop(image, (88.57, 1.80, 0.51), "blue")  # Right side shop(blue)
    image = markShop(image, (0.20, 0.00, 42.00), "grey")  # Jungle shop(grey)

    # Crystals
    image = markCrystal(image, (-76.12, 0.00, 19.90), "red")  # Left side crystal(red)
    image = markCrystal(image, (76.12, 0.10, 19.90), "blue")  # Right side crystal(blue)

    # Turrets
    image = markTurret(image, (-75.48, 0.00, 11.96), "red")  # Left side turret 5(red)
    image = markTurret(image, (-68.59, 0.00, 19.97), "red")  # Left side turret 4(red)
    image = markTurret(image, (-54.00, 0.00, 2.92), "red")  # Left side turret 3(red)
    image = markTurret(image, (-35.78, 0.00, 1.17), "red")  # Left side turret 2(red)
    image = markTurret(image, (-17.06, 0.00, 1.93), "red")  # Left side turret 1(red)

    image = markTurret(image, (75.48, 0.00, 11.96), "blue")  # Right side turret 5(blue)
    image = markTurret(image, (68.59, 0.00, 19.97), "blue")  # Right side turret 4(blue)
    image = markTurret(image, (54.00, 0.00, 2.92), "blue")  # Right side turret 3(blue)
    image = markTurret(image, (35.78, 0.00, 1.17), "blue")  # Right side turret 2(blue)
    image = markTurret(image, (17.06, 0.00, 1.93), "blue")  # Right side turret 1(blue)

    # Jungle minions
    image = markDot(image, (-40.92, 0.00, 20.25))  # Top left minion(grey)
    image = markDot(image, (-43.42, 0.00, 31.11))  # Left crystal mine minion 1(grey)
    image = markDot(image, (-45.00, 0.00, 32.23))  # Left crystal mine minion 2(grey)
    image = markDot(image, (-21.95, 0.00, 24.00))  # Left center jungle minion(grey)
    image = markDot(image, (-14.40, 0.00, 37.67))  # Left shop minion 1(grey)
    image = markDot(image, (-12.51, 0.00, 37.67))  # Left shop minion 2(grey)

    image = markDot(image, (40.59, 0.00, 20.75))  # Top right minion(grey)
    image = markDot(image, (43.49, 0.00, 31.28))  # Right crystal mine minion 1(grey)
    image = markDot(image, (45.60, 0.00, 32.40))  # Right crystal mine minion 2(grey)
    image = markDot(image, (22.50, 0.00, 23.50))  # Right center jungle minion(grey)
    image = markDot(image, (14.85, 0.00, 38.12))  # Right shop minion 1(grey)
    image = markDot(image, (12.89, 0.00, 36.74))  # Right shop minion 2(grey)

    # Save the image
    image.save("imgs\map_1.png")

    # Close the image
    image.close()
