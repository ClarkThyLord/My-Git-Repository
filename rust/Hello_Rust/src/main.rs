use std::io;

// TODO
// Make this actually work
// Random number
// Show stats

fn main() {
    println!("Hello world! Are you looking to play a game? (y/n)");
    let mut input = String::new();
    io::stdin().read_line(&mut input).expect("Failed to read line...");
    if input.to_lowercase() == "y" {
        println!("Great, let's play a guessing game...");
    } else if input.to_lowercase() == "n" {
        println!("...\nWell to bad! We're playing a guessing game...");
    } else {
        println!("Didn't quite catch that, but I'll take it as a yes...\nSo let's play a guessing game...");
    }

    let num = String::from("10");

    println!("Allright, I though of a number, so now you guess what number I've thouht of!... (input integer)");

    let mut reason = String::new();
    loop {
        io::stdin().read_line(&mut input).expect("Failed to read line...");

        if input != num {
            if input > num {
                reason = String::from("high");
            }
            else {
                reason = String::from("low");
            }
            println!("Nope 0_o, your guess was too {}, guess again...", reason);
        }
        else {
            break;
        }
    }

    println!("You've guessed correctly the number {} is what I've thought of!", input);
}
