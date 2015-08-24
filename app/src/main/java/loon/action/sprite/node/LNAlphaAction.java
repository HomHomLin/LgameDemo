/**
 * Copyright 2008 - 2012
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 * 
 * @project loon
 * @author cping
 * @email：javachenpeng@yahoo.com
 * @version 0.3.3
 */
package loon.action.sprite.node;

public class LNAlphaAction extends LNAction {

	protected float _alpha;

	private float oldAlpha;
	
	LNAlphaAction(){
		
	}

	public static LNAlphaAction Action(float a) {
		LNAlphaAction action = new LNAlphaAction();
		action._alpha = a;
		return action;
	}

	@Override
	public void step(float dt) {
		super._target.setAlpha(this._alpha);
		super._isEnd = true;
		oldAlpha = _target._alpha;
	}

	@Override
	public LNAction copy() {
		return Action(_alpha);
	}

	public LNAction reverse() {
		return Action(oldAlpha);
	}
}
