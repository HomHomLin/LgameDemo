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

public class LNCallFuncND extends LNAction {
	
	protected Callback _c;

	protected Object _data;
	
	LNCallFuncND(){
		
	}

	public static LNCallFuncND Action(Callback c, Object data) {
		LNCallFuncND cnd = new LNCallFuncND();
		cnd._c = c;
		cnd._data = data;
		return cnd;
	}

	@Override
	public void step(float dt) {
		_c.invoke(super._target, this._data);
		super._isEnd = true;
	}

	public static interface Callback {
		void invoke(LNNode node, Object data);
	}

	@Override
	public LNAction copy() {
		return Action(_c, _data);
	}
}
