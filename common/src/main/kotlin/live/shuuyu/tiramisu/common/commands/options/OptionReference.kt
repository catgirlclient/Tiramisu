package live.shuuyu.tiramisu.common.commands.options

/**
 * @param name The name of the option.
 * @param required Whether the command's option will be required or not in order to execute the command.
 */
public data class OptionReference<T>(val name: String, val required: Boolean)
