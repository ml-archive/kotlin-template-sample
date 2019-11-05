package dk.nodes.template.presentation.ui.comics

import dk.nodes.template.models.entity.ComicEntity
import dk.nodes.template.presentation.R
import dk.nodes.template.presentation.ui.shared.EntityAdapter
import kotlinx.android.synthetic.main.row_sample.view.*

class ComicsAdapter : EntityAdapter<ComicEntity>(R.layout.row_sample,
    { entity ->
        titleTv.text = entity.title
        bodyTv.text = entity.description
    })