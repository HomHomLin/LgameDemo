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

public class LNCallFunc extends LNAction {

	protected Callback _c;
	
	LNCallFunc(){
		
	}

	public static LNCallFunc Action(Callback c) {
		LNCallFunc func = new LNCallFunc();
		func._c = c;
		return func;
	}

	@Override
	public void step(float dt) {
		this._c.invoke();
		super._isEnd = true;
	}

	public static interface Callback {
		void invoke();
	}

	@Override
	public LNAction copy() {
		return Action(_c);
	}
}
