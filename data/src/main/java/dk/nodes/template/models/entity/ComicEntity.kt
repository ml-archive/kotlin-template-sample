package dk.nodes.template.models.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ComicEntity(
    @PrimaryKey
    override val id: Long,
    val title: String,
    val description: String,
    val thumbnailPath: String,
    val pageCount: Int,
    val price: Float
): DomainEntity