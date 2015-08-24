/**
 * 
 * Copyright 2008 - 2011
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
 * @version 0.1
 */
package loon.core.graphics.component;

public class CollisionBaseQuery implements CollisionQuery {

	private Class<?> cls;

	private Actor compareObject;

	public void init(Class<?> cls, Actor actor) {
		this.cls = cls;
		this.compareObject = actor;
	}

	public boolean checkOnlyCollision(Actor other) {
		return (this.compareObject == null ? true : other
				.intersects(this.compareObject));
	}

	@Override
	public boolean checkCollision(Actor other) {
		return this.cls != null && !this.cls.isInstance(other) ? false
				: (this.compareObject == null ? true : other
						.intersects(this.compareObject));
	}
}
