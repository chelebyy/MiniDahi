package com.minidahi.presentation.age3to5.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.minidahi.R
import com.minidahi.presentation.age3to5.games.ShapeMatchingGame
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ShapeMatchingFragment : Fragment() {
    
    @Inject
    lateinit var game: ShapeMatchingGame
    
    private lateinit var ivTargetShape: ImageView
    private lateinit var btnOption1: ImageButton
    private lateinit var btnOption2: ImageButton
    private lateinit var btnOption3: ImageButton
    private lateinit var tvScore: TextView
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shape_matching, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        initializeViews(view)
        setupGame()
        observeGameState()
    }
    
    private fun initializeViews(view: View) {
        ivTargetShape = view.findViewById(R.id.ivTargetShape)
        btnOption1 = view.findViewById(R.id.btnOption1)
        btnOption2 = view.findViewById(R.id.btnOption2)
        btnOption3 = view.findViewById(R.id.btnOption3)
        tvScore = view.findViewById(R.id.tvScore)
        
        listOf(btnOption1, btnOption2, btnOption3).forEachIndexed { index, button ->
            button.setOnClickListener {
                game.checkAnswer(game.gameState.value?.options?.get(index) ?: "")
            }
        }
    }
    
    private fun setupGame() {
        game.startGame()
    }
    
    private fun observeGameState() {
        game.gameState.observe(viewLifecycleOwner) { state ->
            // Hedef şekli göster
            ivTargetShape.setImageResource(getShapeResource(state.currentShape))
            
            // Seçenekleri güncelle
            val buttons = listOf(btnOption1, btnOption2, btnOption3)
            state.options.forEachIndexed { index, shape ->
                buttons[index].setImageResource(getShapeResource(shape))
            }
            
            // Skoru güncelle
            tvScore.text = "Score: ${state.score}"
        }
    }
    
    private fun getShapeResource(shape: String): Int {
        return when (shape) {
            "circle" -> R.drawable.ic_circle
            "square" -> R.drawable.ic_square
            "triangle" -> R.drawable.ic_triangle
            "star" -> R.drawable.ic_star
            "heart" -> R.drawable.ic_heart
            else -> R.drawable.ic_circle
        }
    }
}
