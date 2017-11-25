package cn.tarena.ht.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.ModuleMapper;
import cn.tarena.ht.pojo.Module;

@Service("moduleService")
public class ModuleServiceImpl implements ModuleService{
	
	@Autowired
	private ModuleMapper moduleMapper;
	
	@Override
	public List<Module> findAll() {
		return moduleMapper.findAll();
	}

	@Override
	public void changeState(int i, String[] moduleIds) {
		moduleMapper.changeState(i,moduleIds);
	}

	@Override
	public void delete(String[] moduleIds) {
		// TODO Auto-generated method stub
		moduleMapper.delete(moduleIds);
		//删除模块和角色关系表
		moduleMapper.deleteModuleByModuleId(moduleIds);
	}

	@Override
	public void save(Module module) {
		// TODO Auto-generated method stub
		module.setModuleId(UUID.randomUUID().toString());
		moduleMapper.save(module);
	}

	@Override
	public Module findOne(String moduleId) {
		// TODO Auto-generated method stub
		return moduleMapper.findOne(moduleId);
	}

	@Override
	public void update(Module module) {
		// TODO Auto-generated method stub
		moduleMapper.update(module);
	}

}
