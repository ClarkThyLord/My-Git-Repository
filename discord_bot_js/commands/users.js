const Discord = require('Discord.js');

module.exports = {
  name: 'users',
  aliases: ['us'],
  description: 'Discord profile on current server\'s users.',
  args: false,
  guild_only: true,
  async execute(bot, msg, args) {
    const reply = await msg.reply('*hello world!*');

    // Setup reactions
    await reply.react('⬅');
    await reply.react('➡');

    bot.msgs.set(reply.id, {
      time: 10,
      command_name: this.name,
      msg: reply,
      args: args,
    });
  },
  async reactionAdd(bot, msg, reaction) {
    await msg.msg.reply(` reaction added: ${reaction.emoji.name}`);
  },
  async reactionRemoved(bot, msg, reaction) {
    await msg.msg.reply(` reaction removed: ${reaction.emoji.name}`);
  },
};