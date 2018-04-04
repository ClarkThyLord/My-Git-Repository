// Import libraries
const fs = require('fs');
const Discord = require('discord.js');

// Setup bot
const bot = new Discord.Client();

// Setup bot's config
bot.config = require('./bot_config.json');

// Setup bot's commands
bot.commands = new Discord.Collection();
const command_files = fs.readdirSync('./commands');
for (const file of command_files) {
  const command = require(`./commands/${file}`);
  bot.commands.set(command.name, command);
}

// Setup bot's event handlers
bot.on('ready', () => {
  bot.user.setPresence({
    game: {
      name: `${bot.config.prefix}help | ${bot.guilds.array().length} Servers`,
    },
  });

  console.log(`Logged in as ${bot.user.tag}!`);
});

bot.on('message', msg => {
  if (!msg.content.startsWith(bot.config.prefix) || msg.author.bot) return;

  // Convert input into command name & args
  const args = msg.content.slice(bot.config.prefix.length).split(/ +/);
  const command_name = args.shift().toLowerCase();

  // Find a command by it's name or aliases
  const command = bot.commands.get(command_name) || bot.commands.find(cmd => cmd.aliases && cmd.aliases.includes(command_name));

  if (!command) return;

  // Check that command requirements are met
  if (command.args && !args.length) {
    return msg.reply(' you didn\'t provide any arguments!');
  }

  if (command.guild_only && msg.channel.type !== 'text') {
    return msg.reply(' I can only execute that command inside servers!');
  }

  try {
    command.execute(bot, msg, args);
  } catch (error) {
    console.error(error);
    msg.reply(' there was an error in trying to execute that command!');
  }
});

// Make bot go online
bot.login(bot.config.token);