module.exports = {
  name: 'server',
  aliases: ['s'],
  description: 'Profile on the current server.',
  args: false,
  guild_only: true,
  execute(bot, msg, args) {
    const guild = msg.guild;

    msg.reply({
      embed: {
        color: 3447003,
        author: {
          name: bot.user.username,
          icon_url: bot.user.avatarURL,
        },
        title: guild.name,
        url: 'https://discord.js.org/#/',
        thumbnail: {
          url: guild.iconURL,
        },
        description: `Just another Discord Server with **${guild.memberCount}** members!`,
        fields: [{
          name: 'Server Information',
          value: `Server Owner: *${guild.owner.user.tag}*\nServer Creation: *${guild.createdAt.toDateString()}*`,
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