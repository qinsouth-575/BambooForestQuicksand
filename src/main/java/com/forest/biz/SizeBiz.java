package com.forest.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.forest.entity.Size;
import com.forest.mapper.SizeMapper;

/**
 * - 业务逻辑层 - 尺码类
 * @author south wind
 * @version v1.0 2019年11月25日 上午7:06:20
 * - 表/功能：
 */
@Service
@Transactional
public class SizeBiz {
	
	@Autowired
	private SizeMapper sizeDAO;
	
    /**
     * - 商品管理 - 商品上传 - 1.查询全部尺码
     * @return
     */
    public List<Size> querySizeAll(){
    	return sizeDAO.selectByExample(null);
    }
	
}
