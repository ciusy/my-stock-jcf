package leo.os.dao.iface;

import java.util.List;

import leo.common.dao.Dao;
import leo.entity.OsfnBlocks;

public interface OsfnBlocksDao extends Dao<OsfnBlocks>{
	/**
	 * 保存功能块表
	 * @param osfnBlocks 内容
	 * @return
	 */
	public boolean addOsfnBlocks(OsfnBlocks osfnBlocks);
	/**
	 * 修改功能块表
	 * @param osfnBlocks 内容
	 * @return
	 */
	public boolean updateOsfnBlocks(OsfnBlocks osfnBlocks);
	/**
	 * 根据功能块名称得到功能模块ID
	 * @param FnBlocksName
	 * @return
	 */
	public Integer getOsfnBlocksID(String FnBlocksName);
	/**
	 * 提取父功能模块
	 * @return
	 */
	public List<OsfnBlocks> getOsfnBlocks();
	/**
	 * 提取子模块
	 * @param FatherFnBlocksID 父功能模块ID
	 * @return
	 */
	public List<OsfnBlocks> getZiMoKuai(Integer FatherFnBlocksID);
	/**
	 * 提取对应功能的类名称
	 * @param FnBlocksID
	 * @return
	 */
	public List<OsfnBlocks> GetGongNengLei(Integer FnBlocksID);
}
