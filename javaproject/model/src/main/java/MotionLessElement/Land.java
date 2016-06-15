package MotionLessElement;
import contract.Permeability;
import Element.Sprite;

public class Land extends MotionLessElement {
	
	

		public Land() {
			super(new Sprite("", "horizontal_bone.png"), Permeability.BLOCKING, '-');
		}


	}

