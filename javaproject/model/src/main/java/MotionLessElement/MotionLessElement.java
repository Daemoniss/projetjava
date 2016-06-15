package MotionLessElement;

import contract.IModel;
import contract.ISprite;
import contract.Permeability;

import Element.Element;

	public abstract class MotionLessElement extends Element /*implements IDoActionOnHeroes */  {
		private final char fileSymbol;

	

		public MotionLessElement(final ISprite sprite, final Permeability permeability, final char fileSymbol) {
			super(sprite, permeability);
		
			this.fileSymbol = fileSymbol;
			
		}

		public char getFileSymbol() {
			return this.fileSymbol;
		}
		


		/*
		@Override
		public ActionOnHeroes getActionOnHeroes() {
			return ActionOnHeroes.NOP;
		}
*/
		


	
}
