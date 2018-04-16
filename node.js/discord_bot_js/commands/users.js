module.exports = {
  name: 'users',
  aliases: ['us'],
  description: 'Discord profile on current server\'s users.',
  args: false,
  guild_only: true,
  async execute(bot, msg, args) {
    const reply = await msg.reply(this.guildProfile(bot, msg.guild));

    // Setup reactions
    await reply.react('⬅');
    await reply.react('➡');

    bot.msgs.set(reply.id, {
      time: 60,
      emojis: ['⬅', '➡'],
      command_name: this.name,
      original: msg,
      reply: reply,
      args: args,
      data: {
        member: -1,
      },
    });
  },
  async onReaction(bot, msg, type, reaction) {
    if (reaction.emoji.name === '⬅') {
      msg.data.member -= 1;
    } else if (reaction.emoji.name === '➡') {
      msg.data.member += 1;
    }

    if (msg.data.member < -1) {
      msg.data.member = -1;
    } else if (msg.data.member > (msg.original.guild.members.keyArray().length - 1)) {
      msg.data.member = msg.original.guild.members.keyArray().length - 1;
    }

    if (msg.data.member === -1) {
      await msg.reply.edit(`<@${msg.original.author.id}>`, this.guildProfile(bot, msg.original.guild));
    } else {
      await msg.reply.edit(`<@${msg.original.author.id}>`, this.userProfile(bot, msg.original.guild.members.get(msg.original.guild.members.keyArray()[msg.data.member]).user));
    }
  },
  guildProfile(bot, guild) {
    return {
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
    };
  },
  userProfile(bot, user) {
    return {
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
    };
  },
};