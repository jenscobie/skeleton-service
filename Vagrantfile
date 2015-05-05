# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure(2) do |config|
  config.vm.box = "precise64"
  config.vm.box_url = "http://files.vagrantup.com/precise64.box"

  config.vm.provision "chef_solo" do |chef|
    chef.cookbooks_path = "provision-package/chef/cookbooks"
    chef.roles_path = "provision-package/chef/roles"
    chef.add_role("service")
  end
end
