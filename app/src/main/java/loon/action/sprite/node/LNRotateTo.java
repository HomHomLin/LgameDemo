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

public class LNRotateTo extends LNAction {

	LNRotateTo(){
		
	}
	
	protected float _diff;

	protected float _orgAngle;

	protected float _tarAngle;

	public static LNRotateTo Action(float duration, float angle) {
		LNRotateTo to = new LNRotateTo();
		to._tarAngle = angle;
		to._duration = duration;
		return to;
	}

	@Override
	public void setTarget(LNNode node) {
		super._firstTick = true;
		super._isEnd = false;
		super._target = node;
		this._orgAngle = node.getRotation();
		this._diff = this._tarAngle - this._orgAngle;
	}

	@Override
	public void update(float t) {
		if (t == 1f) {
			super._isEnd = true;
			super._target.setRotation(this._tarAngle);
		} else {
			super._target.setRotation((t * this._diff) + this._orgAngle);
		}
	}

	@Override
	public LNAction copy() {
		return Action(_duration, _tarAngle);
	}
}
