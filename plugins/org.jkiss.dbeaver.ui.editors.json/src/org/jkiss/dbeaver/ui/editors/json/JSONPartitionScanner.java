/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2023 DBeaver Corp and others
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jkiss.dbeaver.ui.editors.json;

import org.eclipse.jface.text.rules.*;


public class JSONPartitionScanner extends RuleBasedPartitionScanner {
	public static final String JSON_PARTITIONING= "__json_partitioning"; //$NON-NLS-1$
	public final static String JSON_STRING = "__json_string"; //$NON-NLS-1$

	public JSONPartitionScanner() {
		IToken jsonStringToken = new Token(JSONPartitionScanner.JSON_STRING);

		IPredicateRule[] rules = new IPredicateRule[1];

		rules[0] = new MultiLineRule("\"", "\"", jsonStringToken, '\\'); //$NON-NLS-2$ //$NON-NLS-1$
		//rules[0] = new MultiLineRule("'", "'", jsonString, '\\'); //$NON-NLS-2$ //$NON-NLS-1$

		setPredicateRules(rules);
	}
}
