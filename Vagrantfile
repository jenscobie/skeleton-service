# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure(2) do |config|
  config.vm.box = "chef/centos-6.6"
  config.vm.network "forwarded_port", guest: 8080, host: 8080
  config.vm.network "forwarded_port", guest: 8081, host: 8081

  config.vm.provision :ansible do |ansible|
    ansible.playbook = "provision/roles/jenscobie.skeleton-service/site.yml"
    ansible.sudo = true
  end
end
