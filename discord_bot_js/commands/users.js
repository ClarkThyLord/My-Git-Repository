const Discord = require('Discord.js');

module.exports = {
  name: 'users',
  aliases: ['us'],
  description: 'Discord profile on current server\'s users.',
  args: false,
  guild_only: true,
  execute(bot, msg, args) {
    msg.reply('hello world!').then(reply => {
      // Setup emojis
      reply.react('⬅').then(() =>
        reply.react('➡')).catch(() =>
        console.log('Error: Sendind emojis'));

      // const filter = (reaction, user) => {
      //   console.log(reaction.emoji.name);
      //   console.log(user.id);
      //   console.log(msg.author.id);
      //   return (reaction.emoji.name === '⬅' || reaction.emoji.name === '➡') && user.id === msg.author.id;
      // };
      // const collector = msg.awaitReactions(filter, {
      //   time: 15000,
      // });
      // collector.on('collect', reaction => console.log(`Collected ${reaction.emoji.name}`));
      // collector.on('end', collected => console.log(`Collected ${collected.size} items`));
    }).catch();
  },
};