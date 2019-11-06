package dk.nodes.template.models.mapper

import dk.nodes.template.models.dto.Comic
import dk.nodes.template.models.entity.ComicEntity

object ComicMapper : EntityMapper<ComicEntity, Comic> {
    override fun mapToEntity(dto: Comic): ComicEntity {
        val image = if (dto.images?.isEmpty() == true) {
            dto.thumbnail
        } else {
            dto.images!![0]
        }

        val builder = StringBuilder()
        val items = dto.creators?.items
        if (items?.isNotEmpty() == true) {
            for (i in items.indices) {
                val item = items[i]
                if (i > 0) {
                    builder.append(", ")
                }
                builder.append(item.fullName!!)
            }
        } else {
            builder.append("-")
        }

        return ComicEntity(
            id = dto.id!!.toLong(),
            title = dto.title!!,
            description = dto.description ?: "",
            thumbnailPath = image!!.path + "." + image.extension,
            price = dto.prices?.firstOrNull()?.price ?: 0f,
            pageCount = dto.pageCount!!
        )
    }
}