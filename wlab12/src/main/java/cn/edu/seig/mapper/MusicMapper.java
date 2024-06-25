package cn.edu.seig.mapper;

import cn.edu.seig.pojo.Music;

import java.util.List;

public interface MusicMapper {
    public List<Music> findAllMusics();
    public int addMusic(Music music);
    public Music findMusicById(int id);
    public int updateMusic(Music music);
    public int deleteMusicById(int id);

}
//2240709436雷继凯