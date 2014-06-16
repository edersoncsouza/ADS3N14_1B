package com.ArvoreBinariaAvleRubroNegra.Model;

public class AvlNode {
    	protected int height;       	// Altura
    	protected int key;				// Conteudo
        protected AvlNode left, right;	// Nodos da direita e Esquerda

        public AvlNode ( int theElement ) {
            this( theElement, null, null );
        }

        public AvlNode ( int theElement, AvlNode lt, AvlNode rt ) {
            key = theElement;
            left = lt;
            right = rt;
            height   = 0;
        }
    }