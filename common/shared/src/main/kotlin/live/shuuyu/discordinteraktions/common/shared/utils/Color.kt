package live.shuuyu.discordinteraktions.common.shared.utils

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@JvmInline
public value class Color(private val internalRgb: Int) {
    public constructor(red: Int, green: Int, blue: Int) : this(rgb(red, green, blue))

    public val rgb: Int get() = internalRgb and 0xFFFFFF
    public val red: Int get() = (rgb shr 16) and 0xFF
    public val green: Int get() = (rgb shr 8) and 0xFF
    public val blue: Int get() = (rgb shr 0) and 0xFF

    init {
        require(this.rgb in MIN_COLOR..MAX_COLOR) { "RGB should be in range of $MIN_COLOR..$MAX_COLOR but was ${this.rgb}" }
    }

    public fun toJavaColor(): java.awt.Color = java.awt.Color(red, green, blue)

    override fun toString(): String = "Color(red=$red,green=$green,blue=$blue)"

    public companion object {
        private const val MIN_COLOR = 0
        private const val MAX_COLOR = 0xFFFFFF

        private fun rgb(red: Int, green: Int, blue: Int): Int {
            require(red in 0..255) { "Red should be in range of 0..255 but was $red" }
            require(green in 0..255) { "Green should be in range of 0..255 but was $green" }
            require(blue in 0..255) { "Blue should be in range of 0..255 but was $blue" }


            return red and 0xFF shl 16 or
                    (green and 0xFF shl 8) or
                    (blue and 0xFF) shl 0
        }
    }

    internal object Serializer : KSerializer<Color> {
        override val descriptor: SerialDescriptor
            get() = PrimitiveSerialDescriptor("DiscordInteraKTions.color", PrimitiveKind.INT)

        override fun deserialize(decoder: Decoder): Color = Color(decoder.decodeInt())

        override fun serialize(encoder: Encoder, value: Color) {
            encoder.encodeInt(value.rgb)
        }
    }
}

public fun java.awt.Color.toDiscordInteraKTionsColor(): Color = Color(red, green, blue)