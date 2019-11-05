package dk.nodes.template.models.mapper

interface EntityMapper<E, D> {
    fun mapToEntity(dto: D): E
}