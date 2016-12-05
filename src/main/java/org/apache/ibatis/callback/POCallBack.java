/***************************************************************************************************
 * <pre>
* FILE : POCallBack.java
* CLASS : POCallBack
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
* 		  |2010-9-1| SuMMeR| Created |
* DESCRIPTION:
* </pre>
 **************************************************************************************************/
/**
 * $Id: POCallBack.java,v 0.1 2010-9-1 ����04:41:24 SuMMeR Exp $
 */

package org.apache.ibatis.callback;

import java.sql.ResultSet;

import org.apache.ibatis.util.POMapping;
import org.apache.ibatis.util.POUtil;

/**
 * Function    : 
 * @author     : SuMMeR
 * CreateDate  : 2010-9-1
 * @version    :
 */
public class POCallBack<T extends Object> implements DAOCallback<T>
{
	private Class<T> clz = null;

	public POCallBack(Class<T> clz)
	{
		this.clz = clz;
	}

	/* (non-Javadoc)
	 * @see com.autosys.po3.callback.DAOCallback#wrapper(java.sql.ResultSet, int)
	 */
	public T wrapper(ResultSet rs, int index)
	{
		try
		{
			T po = this.clz.newInstance();
			POMapping mapping = new POMapping(po);
			for (int i = 0; i < mapping.getColSize(); i++)
			{
				Object value = POUtil.getValue(rs, mapping.getColName(i), mapping.getColType(i));
				// modi by weibin 解决model类名不符合默认生成规则时无法正确返回结果的BUG
				//POUtil.invokeSetMethodByField(po, POUtil.getAttributeNameByFieldName(mapping.getColName(i)), value);
				POUtil.invokeSetMethodByField(po, mapping.getPropertyName(i), value);
			}
			return po;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
