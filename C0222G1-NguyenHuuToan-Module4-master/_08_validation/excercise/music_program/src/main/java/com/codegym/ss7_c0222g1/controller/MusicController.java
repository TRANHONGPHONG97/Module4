package com.codegym.ss7_c0222g1.controller;


import com.codegym.ss7_c0222g1.model.Music;
import com.codegym.ss7_c0222g1.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MusicController {
    @Autowired
    private MusicService musicService;

    @GetMapping("/list")
    public String showMusicList(Model model) {
        List<Music> musicList = musicService.findAll();
        model.addAttribute("music", new Music());
        model.addAttribute("musicList", musicList);
        return "music_list";
    }

    @GetMapping("/create")
    public String showFormAddNewMusic(Model model) {
        Music newMusic = new Music();
        model.addAttribute("newMusic", newMusic);
        return "music_add_new";
    }

    @PostMapping("/create")
    public String addNewMusic(@Valid @ModelAttribute("newMusic") Music music, BindingResult result) {
        if (result.hasErrors()) {
            return "music_add_new";
        } else {
            musicService.save(music);
            return "redirect:/list";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("musicEdit", musicService.findById(id));
        return "/music_edit";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("musicEdit") Music music, BindingResult result) {
        if (result.hasErrors()) {
            return "music_edit";
        } else {
            musicService.save(music);
            return "redirect:/list";
        }
    }
}
