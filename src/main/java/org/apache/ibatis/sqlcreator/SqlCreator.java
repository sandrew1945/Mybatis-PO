/***************************************************************************************************
 * <pre>
* FILE : SqlCreator.java
* CLASS : SqlCreator
*
* AUTHOR : SuMMeR
*
* FUNCTION : TODO
*
*
*======================================================================
* CHANGE HISTORY LOG
*----------------------------------------------------------------------
* MOD. NO.| DATE | NAME | REASON | CHANGE REQ.
*----------------------------------------------------------------------
* 		  |2010-8-30| SuMMeR| Created |
* DESCRIPTION:
* </pre>
 **************************************************************************************************/
/**
 * $Id: SqlCreator.java,v 0.1 2010-8-30 下午05:30:34 SuMMeR Exp $
 */

package org.apache.ibatis.sqlcreator;

import org.apache.ibatis.util.POMapping;

/**
 * Function    : SQL生成接口
 * @author     : SuMMeR
 * CreateDate  : 2010-8-30
 * @version    :
 */
public interface SqlCreator
{
	public String selectCreator(POMapping mapping, Object po);

	public String updateCreator(POMapping mapping, Object cond, Object value);

	public String deleteCreator(POMapping mapping, Object po);

	public String insertCreator(POMapping mapping, Object po);

	public String selectCreatorForOrder(POMapping mapping, Object po, String order, String... colName);
}
