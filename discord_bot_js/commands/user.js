module.exports = {
  name: 'user',
  aliases: ['u'],
  usage: '<@user>',
  description: 'Discord profile on the user; or any tagged users if there\'s any.',
  args: false,
  guild_only: false,
  execute(bot, msg, args) {
    let user = msg.author;
    if (msg.mentions.users.keyArray() > 0) user = msg.mentions.users.first();

    msg.reply({
      embed: {
        color: 3447003,
        author: {
          name: bot.user.username,
          icon_url: bot.user.avatarURL,
        },
        title: user.username,
        url: 'https://discord.js.org/#/',
        thumbnail: {
          url: user.avatarURL,
        },
        description: user.bot ? 'Just another Discord Bot!' : 'Just another Discord User!',
        fields: [{
          name: 'User Information',
          value: `User Tag: *${user.tag}*\nJoined Discord: *${user.createdAt.toDateString()}*`,
        }],
        timestamp: new Date(),
        footer: {
          icon_url: bot.user.avatarURL,
          text: bot.config.embed.footer,
        },
      },
    });
  },
};