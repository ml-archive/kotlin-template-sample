package dk.nodes.template.presentation.ui.comics

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dk.nodes.template.domain.entity.ComicEntity
import dk.nodes.template.presentation.R
import dk.nodes.template.presentation.ui.shared.EntityAdapter
import kotlinx.android.synthetic.main.row_comic.view.*

class ComicsAdapter(private val onComicClick: (ComicEntity) -> Unit) :
    EntityAdapter<ComicEntity>(R.layout.row_comic,
        { entity ->
            Glide.with(comicRowIv)
                .load(entity.thumbnailPath)
                .apply(RequestOptions.fitCenterTransform())
                .into(comicRowIv)
            comicRowTitleTv.text = entity.title
            setOnClickListener {
                onComicClick(entity)
            }
        })